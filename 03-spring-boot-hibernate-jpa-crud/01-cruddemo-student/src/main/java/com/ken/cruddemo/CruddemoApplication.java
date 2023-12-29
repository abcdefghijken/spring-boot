package com.ken.cruddemo;

import com.ken.cruddemo.dao.StudentDAO;
import com.ken.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> { // java lambda expression/custom code
			System.out.println("Hello World");
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object.");
		Student tempStudent = new Student("Paul", "Doe", "paul@outlook.com");

		System.out.println("Saving new student object.");
		studentDAO.save(tempStudent);

		System.out.println("Display ID of the saved student: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student object.");
		Student tempStudent = new Student("Paul", "Doe", "paul@outlook.com");

		System.out.println("Saving new student object.");
		studentDAO.save(tempStudent);

		System.out.println("Display ID of the saved student: " + tempStudent.getId());
	}
}
