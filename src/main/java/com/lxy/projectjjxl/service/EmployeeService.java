package com.lxy.projectjjxl.service;

import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.dto.EmployeeVO;
import com.lxy.projectjjxl.domain.entity.Employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:12
 */
public interface EmployeeService {
    CommonPageHelper pagination(Integer page, Integer pageSize, String name, Short sex, LocalDate begin, LocalDate end);

    ApiResult empDelete(List<Integer> ids);

    ApiResult empAdd(Employee employee);

    Employee userLogin(EmployeeVO employeeVO);

    Integer selectUsername(String username);

    Employee select(Integer id);

    void empDeleteById(Integer id);

    void empUpdateInfo(Employee employee);
}
