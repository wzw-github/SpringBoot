package com.wzw.springboot.mapper;

import com.wzw.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{department_name})")
    int insertDept(Department department);

    @Update("update department set department_name=#{department_name} where id=#{id}")
    int updateDept(Department department);

}
