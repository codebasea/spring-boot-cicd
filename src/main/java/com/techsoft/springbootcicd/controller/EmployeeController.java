package com.techsoft.springbootcicd.controller;


import com.techsoft.springbootcicd.model.Employee;
import com.techsoft.springbootcicd.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    EmployeeService empService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {

        return empService.getAllEmployees();

    }

    @RequestMapping(value = "/insertemployee", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody Employee employee) {
        empService.insertEmployee(employee);
    }

}
