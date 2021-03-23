package com.wuj.springclound.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//sping de application.xml
public class ConfigBean {
    @Bean
    @LoadBalanced//实现负载均衡的注解
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
