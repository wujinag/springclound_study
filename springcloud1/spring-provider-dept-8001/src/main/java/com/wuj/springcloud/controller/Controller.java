package com.wuj.springcloud.controller;

import com.wuj.pojo.Dept;
import com.wuj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private DeptService deptService;

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
}
