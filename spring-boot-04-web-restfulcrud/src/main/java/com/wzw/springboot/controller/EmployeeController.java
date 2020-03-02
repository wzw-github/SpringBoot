package com.wzw.springboot.controller;

import com.wzw.springboot.dao.DepartmentDao;
import com.wzw.springboot.dao.EmployeeDao;
import com.wzw.springboot.entities.Department;
import com.wzw.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认会拼接classpath:/templates/***.html
        return "emp/list";
    }

    //跳转员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查询所有部门,存储数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //跳转到添加页面
        return "emp/add";
    }

    //员工添加
    //springMVC自动将请求参数和入参对象的属性进行一一绑定，要求：请求参数的名字和入参的对象的属性名一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //保存员工
        employeeDao.save(employee);



        //添加完成跳转到员工列表
        //redirect:表示重定向到一个地址  /表示当前项路径
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 员工修改,查出当前员工，在页面显示
     * @GetMapping("/emp/{id}") id是路径变量
     * 使用@PathVariable("id")获得路径变量
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //显示所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面,add和update同用一个页面
        return "emp/add";
    }

    //员工修改,需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
