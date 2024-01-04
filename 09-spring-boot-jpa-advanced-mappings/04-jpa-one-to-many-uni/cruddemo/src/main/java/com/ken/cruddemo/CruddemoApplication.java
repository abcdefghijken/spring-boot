package com.ken.cruddemo;

import com.ken.cruddemo.dao.AppDAO;
import com.ken.cruddemo.entity.Course;
import com.ken.cruddemo.entity.Instructor;
import com.ken.cruddemo.entity.InstructorDetail;
import com.ken.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndReviews(appDAO);
			// findCourseAndReviewsWithId(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course with id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void findCourseAndReviewsWithId(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Java Masterclass");
		Review review1 = new Review("Good!");
		Review review2 = new Review("5 stars!");
		Review review3 = new Review("Very informative!");

		course.add(review1);
		course.add(review2);
		course.add(review3);

		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
		System.out.println("Done!");
	}

	private void removeCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(10);
		System.out.println("Done!");
	}

	private void removeInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(1);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);
		course.setTitle("Temporary title");
		appDAO.updateCourse(course);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
		System.out.println("instructor detail: " + tempInstructor.getInstructorDetail());

		tempInstructor.setEmail("temp@outlook.com");
		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
		System.out.println("instructor detail: " + tempInstructor.getInstructorDetail());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		List<Course> courses = appDAO.getCoursesByInstructorId(id);

		tempInstructor.setCourses(courses);
		System.out.println("associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Rengoku", "Kyojuro", "ren@outlook.com");
		InstructorDetail detail = new InstructorDetail("www.youtube.com/ren", "Reading");
		instructor.setInstructorDetail(detail);

		// create courses
		Course tempCourse1 = new Course("Air Guitar - Ultimate Guide");
		Course tempCourse2 = new Course("Play Tennis Pro!");

		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		// saving instructors
		System.out.println("Saving Instructor: " + instructor);
		System.out.println("List of courses to save: " + instructor.getCourses());
		appDAO.save(instructor); // also save the course because of CascadeType.PERSIST
		System.out.println("Done!");
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
//		Instructor instructor = new Instructor("Timmy", "Trumpet", "tim@outlook.com");
//		InstructorDetail detail = new InstructorDetail("www.youtube.com/tim", "DJ");
//		instructor.setInstructorDetail(detail);
		Instructor instructor = new Instructor("Rengoku", "Kyojuro", "ren@outlook.com");
		InstructorDetail detail = new InstructorDetail("www.youtube.com/ren", "Reading");
		instructor.setInstructorDetail(detail);

		System.out.println("Saving Instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");
	}
}
