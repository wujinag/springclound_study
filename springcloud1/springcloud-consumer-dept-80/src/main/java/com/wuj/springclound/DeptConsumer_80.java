package com.wuj.springclound;

import com.wuj.myLoadBanlceRule.MyLoaadBanlanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//在服务启动时候就能去加载自定义的负载均衡Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyLoaadBanlanceRule.class)
public class DeptConsumer_80 {
     public static void main(String[] args) {
          SpringApplication.run(DeptConsumer_80.class,args);
     }

     @Bean
     public MyLoaadBanlanceRule getMyLoaadBanlanceRule(){
          return  new MyLoaadBanlanceRule();
     }
}

