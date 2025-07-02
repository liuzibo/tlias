package com.zeber.service.impl;

import com.zeber.mapper.EmpMapper;
import com.zeber.mapper.StudentMapper;
import com.zeber.pojo.ClazzOption;
import com.zeber.pojo.JobOption;
import com.zeber.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }


    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countDegreeData();
    }

    @Override
    public ClazzOption getClazzData() {
        List<Map<String,Object>> list = studentMapper.countClazzData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazzname")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new ClazzOption(clazzList, dataList);
    }
}
