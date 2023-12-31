package com.ken.cruddemo;

import com.ken.cruddemo.dao.StudentDAO;
import com.ken.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> { // java lambda expression/custom code
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
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
		System.out.println("Creating 3 student objects.");
		Student tempStudent1 = new Student("John", "Doe", "john@outlook.com");
		Student tempStudent2 = new Student("Bronya", "Star", "bronya@outlook.com");
		Student tempStudent3 = new Student("Eternity", "Reverse", "eternity@outlook.com");

		System.out.println("Saving the student objects.");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);

		System.out.println(student.toString());
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student: students) {
			System.out.println(student);
		}
	}


	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student.");
		myStudent.setFirstName("John");

		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students.");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted rows: " + numRowsDeleted);
	}
}
