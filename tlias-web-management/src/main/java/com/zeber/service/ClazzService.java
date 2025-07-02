package com.zeber.service;

import com.zeber.pojo.Clazz;
import com.zeber.pojo.ClazzQueryParam;
import com.zeber.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void save(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAll();
}
