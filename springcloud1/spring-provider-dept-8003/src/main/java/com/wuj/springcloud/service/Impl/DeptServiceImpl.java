package com.wuj.springcloud.service.Impl;

import com.wuj.pojo.Dept;
import com.wuj.springcloud.dao.DeptDao;
import com.wuj.springcloud.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;

    Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    @Override
    public boolean addDept(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept queyDept(Long id) {
        Dept dept = null;
        try {
            logger.info("开始查询单条信息。。。。。。");
             dept =  dao.queyDept(id);
        } catch (Exception e) {
            logger.info("queyDept 查询错误："+e );
        }
    return dept;
    }

    @Override
    public List<Dept> queyAll() {
        return dao.queyAll();
    }

    @Override
    public boolean deleteDept(Long deptNo) {
        return dao.deleteDept(deptNo);
    }
}
