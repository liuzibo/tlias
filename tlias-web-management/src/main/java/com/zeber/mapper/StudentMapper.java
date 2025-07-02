package com.zeber.mapper;

import com.zeber.pojo.Student;
import com.zeber.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Integer score);

    @MapKey("name")
    List<Map> countDegreeData();

    List<Map<String, Object>> countClazzData();
}
