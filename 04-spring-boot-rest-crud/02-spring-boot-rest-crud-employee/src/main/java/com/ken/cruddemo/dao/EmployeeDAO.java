package com.ken.cruddemo.dao;

import com.ken.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
