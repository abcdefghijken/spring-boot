package com.ken.cruddemo;

import com.ken.cruddemo.dao.AppDAO;
import com.ken.cruddemo.entity.Instructor;
import com.ken.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 5;
		System.out.println("Deleting Instructor Details of ID: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Instructor Detail deleted!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding Instructor Details of ID: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Details found! - " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting Instructor of ID: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor deleted!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding Instructor of ID: " + id);
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println("Instructor found! - " + instructor);
		System.out.println("Instructor Details: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Timmy", "Trumpet", "tim@outlook.com");
		InstructorDetail detail = new InstructorDetail("www.youtube.com/tim", "DJ");
		instructor.setInstructorDetail(detail);
//		Instructor instructor = new Instructor("Rengoku", "Kyojuro", "ren@outlook.com");
//		InstructorDetail detail = new InstructorDetail("www.youtube.com/ren", "Reading");
//		instructor.setInstructorDetail(detail);

		System.out.println("Saving Instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");
	}
}
