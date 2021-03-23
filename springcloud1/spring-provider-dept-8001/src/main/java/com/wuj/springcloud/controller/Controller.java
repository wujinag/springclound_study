package com.wuj.springcloud.controller;

import com.wuj.pojo.Dept;
import com.wuj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public  boolean addDept(Dept dept){
     return  deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queyDept(@PathVariable("id") String deptNo){
        return deptService.queyDept(Long.valueOf(deptNo));
    }

    @GetMapping("/dept/list")
    List<Dept> queryAll(){
        return deptService.queyAll();
    }

    @GetMapping("/dept/delete/{id}")
    public boolean delDept(@PathVariable("id") Long deptNo){
        return deptService.deleteDept(deptNo);
    }

    @GetMapping("/dept/serviceinfo")
    public Object disconvery(){
        //获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("Disconvery=>service :"+services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance: instances) {
            System.out.println("Host"+instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getServiceId());
        }
        return this.discoveryClient;
    }
}
