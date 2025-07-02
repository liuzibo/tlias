package com.zeber.service;

import com.zeber.pojo.ClazzOption;
import com.zeber.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzOption getClazzData();
}
