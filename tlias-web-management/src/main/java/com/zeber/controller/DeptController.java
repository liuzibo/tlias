package com.zeber.controller;

import com.zeber.pojo.Dept;
import com.zeber.pojo.Result;
import com.zeber.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @GetMapping
    public Result list(){
        log.info("查询部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门 - delete
     */
    @DeleteMapping
    public Result delete(Integer id){
        System.out.println("根据id删除部门, id=" + id);log.info("根据id删除部门, id: {}" , id);deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门 - POST
     */
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("新增部门, dept: {}" , dept);
        deptService.save(dept);
        return Result.success();
    }

    /**
     * 根据ID查询 - GET
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询, id: {}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }


    /**
     * 修改部门 - PUT
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return Result.success();
    }

}