package com.zeber.service;


import com.zeber.pojo.PageResult;
import com.zeber.pojo.Student;
import com.zeber.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void save(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Integer score);
}
