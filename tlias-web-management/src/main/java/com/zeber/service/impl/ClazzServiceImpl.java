package com.zeber.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zeber.mapper.ClazzMapper;
import com.zeber.mapper.EmpMapper;
import com.zeber.pojo.Clazz;
import com.zeber.pojo.ClazzQueryParam;
import com.zeber.pojo.PageResult;
import com.zeber.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {


    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private EmpMapper empMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        clazzList.forEach(clazz -> {
            if(LocalDate.now().isBefore(clazz.getBeginDate())){
                clazz.setStatus("未开班");
            }else if(LocalDate.now().isAfter(clazz.getEndDate())){
                clazz.setStatus("已结课");
            }else {
                clazz.setStatus("已开班");
            }
        });
        Page<Clazz> p = (Page<Clazz>)clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);

    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }


}
