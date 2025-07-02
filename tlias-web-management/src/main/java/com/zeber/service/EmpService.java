package com.zeber.service;

import com.zeber.pojo.Emp;
import com.zeber.pojo.EmpQueryParam;
import com.zeber.pojo.LoginInfo;
import com.zeber.pojo.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);


    Emp getInfo(Integer id);

    void update(Emp emp);


    List<Emp> findAll();

    LoginInfo login(Emp emp);
}