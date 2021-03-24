package com.wuj.springclound.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//sping de application.xml
public class ConfigBean {
    //Irule 负载均衡算法 多个实现算法类 AbstractLoadBalancerRule  RoundRobinRule（轮询） 等等
    // 随机 (Random)
    //轮询 (RoundRobin)
    //一致性哈希 (ConsistentHash)
    //哈希 (Hash)
    //加权（Weighted）
    @Bean
    @LoadBalanced//ribbon 实现负载均衡
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
