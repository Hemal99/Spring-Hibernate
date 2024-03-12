package com.hemal.cruddemo;

import com.hemal.cruddemo.dao.StudentDAO;
import com.hemal.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
			return runner -> {
//				createMultipleStudent(studentDAO);

//				readStudent(studentDAO);

//				queryForStudents(studentDAO);

//				queryForStudentsByLastName(studentDAO);

				updateStudent(studentDAO);
			};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 11;
		System.out.println("Getting student with id :" + studentId);
		Student myStudent = studentDAO.findById(studentId);


		// change first name to "Scooby"
		System.out.println("Updating Student ...");
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		System.out.println("Updated Student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// display

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// geta a list of students
		List<Student> theStudent = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student

		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

		// save the student
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated Id " + theId);

		// retrieve student based on the id : primary key

		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);




	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student objects ...");
		// create multiple students

		Student tempStudent1 = new Student("githmin","Perera","hemal@gmail.com");
		Student tempStudent2 = new Student("chanath","Perera","chanath@gmail.com");
		Student tempStudent3 = new Student("Roni","Perera","Roni@gmail.com");

		// save the student objects
		System.out.println("Saving new student object ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	;

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Hemal","Perera","hemal@gmail.com");

		// save
		System.out.println("Saving the student object ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}


}
