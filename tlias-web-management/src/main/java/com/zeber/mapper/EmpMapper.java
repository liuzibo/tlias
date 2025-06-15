package com.zeber.mapper;

import com.zeber.pojo.Emp;
import com.zeber.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询所有的员工及其对应的部门名称
     */
    List<Emp> list(EmpQueryParam empQueryParam);
}