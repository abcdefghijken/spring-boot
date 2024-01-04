package com.ken.cruddemo.dao;

import com.ken.cruddemo.entity.Instructor;
import com.ken.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
