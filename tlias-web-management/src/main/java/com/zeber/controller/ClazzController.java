package com.zeber.controller;


import com.zeber.anno.LogOperation;
import com.zeber.pojo.Clazz;
import com.zeber.pojo.ClazzQueryParam;
import com.zeber.pojo.PageResult;
import com.zeber.pojo.Result;
import com.zeber.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;


    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("clazzQueryParam:{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("clazzQueryParam:{}",id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);

    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("clazzQueryParam:{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("clazzQueryParam:{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("clazzQueryParam:{}",clazz);
        clazzService.update(clazz);
        return Result.success();

    }

    @GetMapping("/list")
    public Result list(){
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

}
