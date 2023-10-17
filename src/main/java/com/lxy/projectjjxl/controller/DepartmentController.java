package com.lxy.projectjjxl.controller;


import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.entity.Department;
import com.lxy.projectjjxl.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:08
 */

@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping("/department")
    public ApiResult list(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize){
        CommonPageHelper commonPageHelper = departmentService.departAll(page, pageSize);
        log.info("查询全部部门数据");
        return ApiResult.success(commonPageHelper);
    }

    /**
     * 根据id删除某个部门
     * @param id
     * @return
     */
    @DeleteMapping("/department/{id}")
    public ApiResult delete(@PathVariable Integer id){
        int department = departmentService.departDelete(id);
        return ApiResult.success(department);
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @PostMapping("/department")
    public ApiResult add(@RequestBody Department department){
        int dept = departmentService.deptAdd(department);
        return ApiResult.success(dept);
    }

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    @GetMapping("/department/{id}")
    public ApiResult GetById(@PathVariable Integer id){
        Department department = departmentService.deptGetById(id);
        return ApiResult.success("查询成功",department);
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @PutMapping("/department")
    public ApiResult deptUpdate(@RequestBody Department department){
        int dept = departmentService.update(department);
        return ApiResult.success("修改成功",dept);
    }
}
