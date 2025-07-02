package com.zeber.mapper;

import com.zeber.pojo.Clazz;
import com.zeber.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    void updateById(Clazz clazz);

    List<Clazz> findAll();
}
