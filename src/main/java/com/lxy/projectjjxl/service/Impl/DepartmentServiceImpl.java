package com.lxy.projectjjxl.service.Impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.entity.Department;
import com.lxy.projectjjxl.mapper.DepartmentMapper;
import com.lxy.projectjjxl.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:08
 */

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public CommonPageHelper departAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Department> departmentList = departmentMapper.departList();
        Page<Department> p = (Page<Department>) departmentList;
        log.info("page里面数据：{}",p);
        CommonPageHelper commonPageHelper = new CommonPageHelper(p.getTotal(),p.getResult());
        return commonPageHelper;
    }

    @Override
    public int departDelete(Integer id) {
        int result = departmentMapper.deleteId(id);
        return result;
    }

    @Override
    public int deptAdd(Department department) {
        department.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        department.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        int dept = departmentMapper.deptInsert(department);
        return dept;
    }

    @Override
    public Department deptGetById(Integer id) {
        Department deptById = departmentMapper.deptById(id);
        return deptById;
    }

    @Override
    public int update(Department department) {
        department.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        int dept = departmentMapper.modify(department);
        return dept;
    }
}
