package com.wuj.myLoadBanlceRule;


import com.netflix.client.config.IClientConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//自定义负载均衡算法
public class MyRoundRobinRule extends AbstractLoadBalancerRule {
    private AtomicInteger nextServerCyclicCounter;
    private AtomicInteger totalServerCyclicCounter;
    private static Logger log = LoggerFactory.getLogger(com.netflix.loadbalancer.RoundRobinRule.class);

    public MyRoundRobinRule() {
        this.nextServerCyclicCounter = new AtomicInteger(0);
        this.totalServerCyclicCounter = new AtomicInteger(0);
    }

    public MyRoundRobinRule(ILoadBalancer lb) {
        this();
        this.setLoadBalancer(lb);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                //int index = this.chooseRandomInt(serverCount);
                //server = (Server)upList.get(index);
                //自定义算法：执行5次，换下一个服务器执行
                if(totalServerCyclicCounter.get() < 4){
                    server = upList.get(nextServerCyclicCounter.get());
                    totalServerCyclicCounter.getAndIncrement();
                }else{
                    totalServerCyclicCounter.set(0);
                    nextServerCyclicCounter.getAndIncrement();
                    if(nextServerCyclicCounter.get() >= upList.size()){
                        nextServerCyclicCounter.set(0);
                    }
                    server = upList.get(nextServerCyclicCounter.get());//从活着的服务中获取服务
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }



    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
