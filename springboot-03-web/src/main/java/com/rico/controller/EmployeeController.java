package com.rico.controller;

import com.rico.dao.DepartmentDao;
import com.rico.dao.EmployeeDao;
import com.rico.pojo.Department;
import com.rico.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Rico_dds
 * @date 2020/7/27 12:46
 */

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门的数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println("employee>>>>"+employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }



}

