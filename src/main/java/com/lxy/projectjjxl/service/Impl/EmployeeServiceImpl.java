package com.lxy.projectjjxl.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lxy.projectjjxl.common.ApiResult;
import com.lxy.projectjjxl.domain.dto.CommonPageHelper;
import com.lxy.projectjjxl.domain.dto.EmployeeVO;
import com.lxy.projectjjxl.domain.entity.Employee;
import com.lxy.projectjjxl.mapper.EmployeeMapper;
import com.lxy.projectjjxl.service.EmployeeService;
import com.lxy.projectjjxl.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:12
 */

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 员工分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public CommonPageHelper pagination(Integer page, Integer pageSize, String name, Short sex, LocalDate begin, LocalDate end) {
//        long count = employeeMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Employee> list = employeeMapper.page(start,pageSize);
//        log.info("查询出来的记录：{}",list);
//        EmpPageHelper empPageHelper = new EmpPageHelper(count, list);

        PageHelper.startPage(page, pageSize);
        List<Employee> employeeList = employeeMapper.list(name, sex, begin, end);
        Page<Employee> p = (Page<Employee>) employeeList;
        CommonPageHelper commonPageHelper = new CommonPageHelper(p.getTotal(), p.getResult());
        return commonPageHelper;
    }

    /**
     * 批量删除用户
     *
     * @param ids
     */
    @Override
    public ApiResult empDelete(List<Integer> ids) {
        employeeMapper.delete(ids);
        return null;
    }

    /**
     * 新增员工
     *
     * @param employee
     */
    @Override
    public ApiResult empAdd(Employee employee){
        //查询用户是否存在
        Integer count = employeeMapper.selectUsername(employee.getUsername());
        if (count > 0) {
            log.info("查询用户个数：{}",count);
            return ApiResult.fail(1001, "用户已存在");
        } else {
            employee.setPassword("123456");
            employee.setCreateTime(LocalDateTime.now());
            employee.setUpdateTime(LocalDateTime.now());
            employeeMapper.insert(employee);
            log.info("新增用户成功");
            return ApiResult.success();

        }
    }

    /**
     * 用户登录
     *
     * @param employeeVO
     * @return
     */
    @Override
    public Employee userLogin(EmployeeVO employeeVO) {
//        Employee emp = new Employee();
//        if(emp.getUsername().equals(employeeVO.getUsername()) && emp.getPassword().equals(employeeVO.getPassword())){
//            employeeMapper.empLogin(employeeVO);
//        }
//        else {
//            ApiResult.fail("用户名密码错误，请重新输入");
//        }
        String x = employeeVO.getUsername();
        String y = employeeVO.getPassword();
        return employeeMapper.empLogin(x, y);

    }

    /**
     * 查询单个用户
     *
     * @param username
     * @return
     */
    @Override
    public Integer selectUsername(String username) {
        Integer empCount = employeeMapper.selectUsername(username);
        return empCount;
    }

    /**
     * 查询用户id,用于编辑回显数据
     * @param id
     * @return
     */
    @Override
    public Employee select(Integer id) {
        Employee emp = employeeMapper.selectId(id);
        return emp;
    }

    /**
     * 删除一个用户
     *
     * @param id
     */
    @Override
    public void empDeleteById(Integer id) {
        employeeMapper.empDeleteId(id);
    }

    /**
     * 更新用户
     *
     * @param employee
     */
    @Override
    public void empUpdateInfo(Employee employee) {
        employee.setUpdateTime(LocalDateTime.now());
        employeeMapper.empUpdate(employee);
    }
}
