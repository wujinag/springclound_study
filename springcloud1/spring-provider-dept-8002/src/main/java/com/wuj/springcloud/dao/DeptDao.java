package com.wuj.springcloud.dao;

import com.wuj.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept queyDept(@PathVariable("deptNo") Long id);
    List<Dept> queyAll();
    boolean deleteDept(Long deptNo);
}
