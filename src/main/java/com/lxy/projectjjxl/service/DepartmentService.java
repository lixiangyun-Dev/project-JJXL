package com.lxy.projectjjxl.service;

import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.entity.Department;

import java.util.List;

public interface DepartmentService {

    CommonPageHelper departAll(Integer page, Integer pageSize);

    int departDelete(Integer id);

    int deptAdd(Department department);

    Department deptGetById(Integer id);

    int update(Department department);
}
