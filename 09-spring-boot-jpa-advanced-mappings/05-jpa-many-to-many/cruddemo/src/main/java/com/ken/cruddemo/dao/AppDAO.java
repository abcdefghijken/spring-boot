package com.ken.cruddemo.dao;

import com.ken.cruddemo.entity.Course;
import com.ken.cruddemo.entity.Instructor;
import com.ken.cruddemo.entity.InstructorDetail;
import com.ken.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> getCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void update(Student student);
    void deleteStudentById(int id);
}
