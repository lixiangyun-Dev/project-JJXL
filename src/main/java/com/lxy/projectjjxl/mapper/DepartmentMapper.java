package com.lxy.projectjjxl.mapper;


import com.lxy.projectjjxl.domain.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

//    @Select("SELECT id, name, create_time, update_time from tb_department")
    List<Department> departList();


//    @Delete("delete from tb_department where id = #{id}")
    int deleteId(Integer id);

//    @Insert("insert into tb_department(name, create_time, update_time)values (#{name},#{createTime},#{updateTime})")
    int deptInsert(Department department);

//    @Select("select id, name, create_time, update_time from tb_department where id = #{id}")
    Department deptById(Integer id);

//    @Update("update tb_department set name = #{name},update_time = #{updateTime} where id = #{id}")
    int modify(Department department);
}
