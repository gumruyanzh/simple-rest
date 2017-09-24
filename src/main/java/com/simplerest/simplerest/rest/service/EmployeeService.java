package com.simplerest.simplerest.rest.service;

import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> getAllEmployees();

    public void addNewEmployee(EmployeeEntity employeeEntity);

    public EmployeeEntity findById(int id);

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
}
