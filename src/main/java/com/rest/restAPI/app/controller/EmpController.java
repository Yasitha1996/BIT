package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.mapping.Employee;
import com.rest.restAPI.app.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Employee> getEmp(){
        return employeeRepo.findAll();
    }
}
