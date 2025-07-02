package com.zeber.controller;

import com.zeber.pojo.EmpLog;
import com.zeber.pojo.PageResult;
import com.zeber.pojo.Result;
import com.zeber.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(@RequestParam Integer page, @RequestParam Integer pageSize){
        PageResult<EmpLog> pageResult = logService.page(page, pageSize);
        return Result.success();
    }


}
