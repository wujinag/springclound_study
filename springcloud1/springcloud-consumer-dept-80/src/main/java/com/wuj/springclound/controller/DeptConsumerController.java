package com.wuj.springclound.controller;

import com.wuj.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class DeptConsumerController {
    //消费者，不应该有service层
    //ResTemplate直接注入spring 调用即可
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问http服务的方法，简单的Restful服务模板

    private static final String REST_URL_PERFiX ="http://localhost:8001/dept-provider";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PERFiX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queyDeptList(){
        return restTemplate.getForObject(REST_URL_PERFiX+"/dept/list",List.class);
    }

}
