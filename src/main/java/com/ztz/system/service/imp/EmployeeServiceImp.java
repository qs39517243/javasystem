package com.ztz.system.service.imp;

import com.ztz.system.pojo.Employee;

import java.util.List;

public interface EmployeeServiceImp {

    // 通过id查找职员
    public Employee getEmployeeById(Integer id);

    // 查找全部职员
    public List<Employee> getAllEmployees();

    // 条件查找部分职员
    public List<Employee> getSelectiveEmployees(String text);

    // 增
    public int addEmployee(Employee employee);

    // 删
    public int deleteEmployee(Integer id);

    // 改
    public int updateEmployee(Employee employee);
}
