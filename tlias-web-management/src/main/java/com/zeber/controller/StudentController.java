package com.zeber.controller;


import com.zeber.pojo.PageResult;
import com.zeber.pojo.Result;
import com.zeber.pojo.Student;
import com.zeber.pojo.StudentQueryParam;
import com.zeber.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score){
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
