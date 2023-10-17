package com.lxy.projectjjxl.controller;

import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.dto.EmployeeVO;
import com.lxy.projectjjxl.domain.entity.Employee;
import com.lxy.projectjjxl.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:12
 */

@RestController
@Slf4j
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 用户分页查询
     * @param page 第几页，例如第1页
     * @param pageSize 每一页显示多少条，例如10条
     * @return
     */
    @GetMapping("/employee")
    public ApiResult pageHelper(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                String name, Short sex,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        CommonPageHelper commonPageHelper = employeeService.pagination(page,pageSize,name,sex,begin,end);
        return ApiResult.success(commonPageHelper);
    }

    /**
     * 用户批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/employee/ids/{ids}")
    public ApiResult delete(@PathVariable List<Integer> ids){
        return ApiResult.success(employeeService.empDelete(ids));
    }

    /**
     * 员工新增
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public ApiResult<Object> add(@RequestBody Employee employee){
        return ApiResult.success(employeeService.empAdd(employee));
    }

    /**
     * 查询单个用户
     * @param username
     * @return
     */
    @GetMapping("/employee/{username}")
    public ApiResult empByUsername(@PathVariable String username){
        Integer count = employeeService.selectUsername(username);
        log.info("查询返回的记录数: {}",count);
        return ApiResult.success(count);
    }

    /**
     * 查询用户id,用于编辑回显数据
     * @param id
     * @return
     */
    @GetMapping("/employee/empById/{id}")
    public ApiResult empById(@PathVariable Integer id){
        Employee employee = employeeService.select(id);
        log.info("根据用户id查询的记录数: {}",employee);
        return ApiResult.success(employee);
    }

    /**
     * 删除一个用户记录
     * @param id
     * @return
     */
    @DeleteMapping("/employee/DeleteById/{id}")
    public ApiResult empDelete(@PathVariable Integer id){
        employeeService.empDeleteById(id);
        return ApiResult.success();
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public ApiResult empUpdate(@RequestBody Employee employee){
        employeeService.empUpdateInfo(employee);
        return ApiResult.success();
    }


    /**
     * 员工登录
     * @param employeeVO
     * @return
     */
    @PostMapping("/login")
    public ApiResult login(@RequestBody EmployeeVO employeeVO){
        Employee emp = employeeService.userLogin(employeeVO);
        return ApiResult.success("登录成功",emp);
    }
}
