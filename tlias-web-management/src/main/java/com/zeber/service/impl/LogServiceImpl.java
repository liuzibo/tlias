package com.zeber.service.impl;

import com.github.pagehelper.PageHelper;
import com.zeber.mapper.EmpMapper;
import com.zeber.pojo.EmpLog;
import com.zeber.pojo.PageResult;
import com.zeber.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Override
    public PageResult<EmpLog> page(Integer page, Integer pageSize) {
        return null;
    }
}
