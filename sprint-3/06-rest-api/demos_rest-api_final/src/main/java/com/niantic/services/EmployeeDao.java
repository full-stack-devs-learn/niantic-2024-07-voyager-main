package com.niantic.services;

import com.niantic.models.Employee;

import java.util.List;

public interface EmployeeDao
{
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);
}
