package com.techsoft.springbootcicd.service;


import com.techsoft.springbootcicd.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void insertEmployee(Employee employee);
}