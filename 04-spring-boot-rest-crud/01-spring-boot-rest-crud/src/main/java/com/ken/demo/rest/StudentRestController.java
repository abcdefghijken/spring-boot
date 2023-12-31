package com.ken.demo.rest;

import com.ken.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList();
        students.add(new Student("Bronya", "Diamond"));
        students.add(new Student("Seele", "Quantum"));
        students.add(new Student("Ken", "Amadeus"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) { // bind the path variable (by default, must match)
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return students.get(studentId);
    }
}
