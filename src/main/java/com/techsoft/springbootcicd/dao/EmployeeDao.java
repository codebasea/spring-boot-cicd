package com.techsoft.springbootcicd.dao;


import com.techsoft.springbootcicd.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);
}