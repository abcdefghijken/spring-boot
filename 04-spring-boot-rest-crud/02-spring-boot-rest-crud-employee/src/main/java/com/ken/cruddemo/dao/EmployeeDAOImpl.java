package com.ken.cruddemo.dao;

import com.ken.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // don't use @Transactional, handled by Service Layer
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired // inject
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee); // if id == 0 then insert/save, else update
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(dbEmployee);
    }
}
