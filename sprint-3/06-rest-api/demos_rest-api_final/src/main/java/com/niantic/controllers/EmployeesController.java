package com.niantic.controllers;

import com.niantic.services.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController
{
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeesController(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmployees()
    {
        var employees = employeeDao.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
