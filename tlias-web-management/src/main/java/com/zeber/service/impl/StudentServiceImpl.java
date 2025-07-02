package com.zeber.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zeber.mapper.StudentMapper;
import com.zeber.pojo.PageResult;
import com.zeber.pojo.Student;
import com.zeber.pojo.StudentQueryParam;
import com.zeber.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Transactional
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> studentList = studentMapper.list(studentQueryParam);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }

}
