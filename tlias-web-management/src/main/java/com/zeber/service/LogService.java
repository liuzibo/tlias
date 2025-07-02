package com.zeber.service;

import com.zeber.pojo.EmpLog;
import com.zeber.pojo.PageResult;

public interface LogService {
    PageResult<EmpLog> page(Integer page, Integer pageSize);
}
