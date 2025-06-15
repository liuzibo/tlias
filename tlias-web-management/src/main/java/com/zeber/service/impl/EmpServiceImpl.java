package com.zeber.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zeber.mapper.EmpMapper;
import com.zeber.pojo.Emp;
import com.zeber.pojo.EmpQueryParam;
import com.zeber.pojo.PageResult;
import com.zeber.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>)empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}