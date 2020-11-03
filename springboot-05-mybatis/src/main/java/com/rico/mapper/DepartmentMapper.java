package com.rico.mapper;

import com.rico.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/11/3 16:40
 */

@Mapper
@Repository
public interface DepartmentMapper {

    // 获取所有部门信息
    List<Department> getDepartmentList();

    // 通过id获得部门
    Department getDepartmentById(Integer id);


    int addDepartment(Department department);


    int deleteDepartmentsById(int id);

}

