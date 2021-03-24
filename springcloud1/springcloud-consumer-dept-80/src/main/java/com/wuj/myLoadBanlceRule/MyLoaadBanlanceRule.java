package com.wuj.myLoadBanlceRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyLoaadBanlanceRule {
    @Bean
    @LoadBalanced//ribbon 实现负载均衡
    public IRule getMyLoaadBanlanceRule(){
        return  new MyRoundRobinRule();//默认使用的是轮询，现在如今使用自己的算法
    }

}
