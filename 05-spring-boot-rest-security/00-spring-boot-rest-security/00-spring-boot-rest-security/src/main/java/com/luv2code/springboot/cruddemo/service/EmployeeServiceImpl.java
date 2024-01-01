package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id); // different pattern instead of having to check for nulls, introduced in java 8

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee ID - " + id);
        }

        return employee;
    }

    @Override // JpaRepository provides @Transactional - no need to annotate
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override // JpaRepository provides @Transactional - no need to annotate
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
