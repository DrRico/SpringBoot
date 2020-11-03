package com.rico.controller;

import com.rico.mapper.DepartmentMapper;
import com.rico.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/11/3 16:43
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    // 查询全部部门
    @GetMapping("/getDepartmentList")
    public List<Department> getDepartments(){

        List<Department> departmentList = departmentMapper.getDepartmentList();
        for(Department department : departmentList){
            System.out.println(department);
        }
        return departmentList;
    }

    // 通过Id查询部门
    @GetMapping("/getDepartmentById/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        Department department = departmentMapper.getDepartmentById(id);
        System.out.println(department);
        return department;
    }

    @GetMapping("/deleteDepartmentsById/{id}")
    public String deleteDepartmentsById(@PathVariable("id")Integer id){
        String name = getDepartment(id).getDepartmentName();
        departmentMapper.deleteDepartmentsById(id);
        System.out.println("删除用户成功:" + name);
        return "删除用户成功:" + name;
    }

    @GetMapping("/addDepartments/{id}&{dptName}")
    public String addDepartments(@PathVariable("id")Integer id,@PathVariable("dptName")String dptName){
        departmentMapper.addDepartment(new Department(id,dptName));
        System.out.println("添加用户成功:" + dptName);
        return "添加用户成功:" + dptName;
    }

}