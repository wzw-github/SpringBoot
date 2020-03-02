package com.wzw.springboot.mapper;

import com.wzw.springboot.bean.Employee;
import org.springframework.stereotype.Repository;

//使用@Mapper或在SpringBoot启动类上使用@Mapperscan指定Mapper包
@Repository
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);

}
