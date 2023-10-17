package com.lxy.projectjjxl.mapper;

import com.lxy.projectjjxl.domain.dto.EmployeeVO;
import com.lxy.projectjjxl.domain.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author LiXiangYun
 * @version 1.0
 * @date 2023/9/27 10:12
 */

@Mapper
public interface EmployeeMapper {

//    @Select("select count(*) from tb_employee")
//    public long count();
//
//    @Select("select * from tb_employee limit #{index},#{pageSize}")
//    public List<Employee> page(Integer index,Integer pageSize);

//    @Select("select * from tb_employee")
    public List<Employee> list(String name, Short sex, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Employee employee);

    @Select("select * from tb_employee where username = #{x} and password = #{y}")
    Employee empLogin(String x ,String y);

    @Select("select count(*) from tb_employee where username = #{username}")
    Integer selectUsername(String username);

    @Select("select * from tb_employee where id = #{id}")
    Employee selectId(Integer id);

    @Delete("delete from tb_employee where id = #{id}")
    void empDeleteId(Integer id);

    void empUpdate(Employee employee);


//    public List<Employee> EmpConditionalQuery();
}
