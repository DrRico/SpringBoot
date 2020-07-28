package com.rico.dao;

import com.rico.pojo.Department;
import com.rico.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rico_dds
 * @date 2020/7/23 22:41
 */
//员工DAO

@Repository

public class EmployeeDao {

    //模拟数据库
    private static Map<Integer, Employee> employees = null;
    //员工有所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"A小黄","A123456",1,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"B小红","B123456",0,new Department(101,"后勤部")));
        employees.put(1003,new Employee(1003,"C小白","C123456",1,new Department(101,"后勤部")));
        employees.put(1004,new Employee(1004,"D小黑","D123456",0,new Department(101,"后勤部")));
        employees.put(1005,new Employee(1005,"E小青","E123456",1,new Department(101,"后勤部")));
    }
    private static Integer initId = 1006;
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId ++);
        }
        employee.setDepartment(departmentDao.getDepartmentsById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过ID查询员工信息
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //通过ID删除员工信息
    public Employee deleteEmployeeById(Integer id){
        return employees.remove(id);
    }
}
