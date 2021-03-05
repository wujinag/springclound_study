package com.wuj.springcloud.service;

import com.wuj.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);
    Dept queyDept(Long deptNo);
    List<Dept> queyAll();
    boolean deleteDept(Long deptNo);
}
