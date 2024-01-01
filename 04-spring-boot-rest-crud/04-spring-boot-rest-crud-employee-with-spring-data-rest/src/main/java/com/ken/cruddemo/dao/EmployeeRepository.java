package com.ken.cruddemo.dao;

import com.ken.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
