package com.zeber.service;

import com.zeber.pojo.Emp;
import com.zeber.pojo.EmpQueryParam;
import com.zeber.pojo.PageResult;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}