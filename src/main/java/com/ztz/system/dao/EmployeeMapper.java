package com.ztz.system.dao;

import com.ztz.system.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    // 通过id查找职员
    Employee getEmployeeById(Integer id);

    // 查找所有职员
    List<Employee> getAllEmployees();

    // 条件查找部分职员
    List<Employee> getSelectiveEmployees(String text);

    // 增
    int addEmployee(Employee employee);

    // 删
    int deleteEmployee(Integer id);

    // 改
    int updateEmployee(Employee employee);
}