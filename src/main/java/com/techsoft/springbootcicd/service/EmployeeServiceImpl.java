package com.techsoft.springbootcicd.service;


import com.techsoft.springbootcicd.dao.EmployeeDao;
import com.techsoft.springbootcicd.model.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        employees.forEach(System.out::println);
        return employees;
    }

    @Override
    public void insertEmployee(Employee employee) {
        log.info("Employee > {}", employee);
        employeeDao.insertEmployee(employee);

    }

}