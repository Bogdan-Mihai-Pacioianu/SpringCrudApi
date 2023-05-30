package com.example.springapidb;

import com.example.springapidb.dao.StudentDAO;
import com.example.springapidb.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class CrudApp {

	public static void main(String[] args) {
		SpringApplication.run(CrudApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> { 
			//createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//querForStudents(studentDAO);

			queryForStudentByLastName(studentDAO);

		};
		
	}



	// implement method create student

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Create new student object ...");
		Student theStudent = new Student("Paul", "Doel", "pulddoe@gmail.com", "Harvard");

		// Save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(theStudent);

		// Display id of the saved student
		System.out.println("Display the student. Generated id: " + theStudent.getId());
	}



	// implement method create multiple students
	private void createMultipleStudent(StudentDAO studentDAO) {

		// Create the students
		System.out.println("Create 6 students objects");
		Student theStudent1 = new Student("Samuel", "Norrise", "norrise@gmail.com", "UPB");
		Student theStudent2 = new Student("Roni", "Teeu", "teeu@gmail.com", "HREu");
		Student theStudent3 = new Student("Bogdan", "Je", "je@gmail.com", "BGS");
		Student theStudent4 = new Student("David", "Neo", "david@gmail.com", "UPJ");
		Student theStudent5 = new Student("Miguel", "Urs", "miguel@gmail.com", "UNIBUC");
		Student theStudent6 = new Student("Carlos", "Frunza", "carlos@gmail.com", "UPIT");

		// Save the students objects
		System.out.println("Save teh students...");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);
		studentDAO.save(theStudent4);
		studentDAO.save(theStudent5);
		studentDAO.save(theStudent6);
	}



	//	create method to find student
	public void readStudent(StudentDAO studentDAO) {

		// create the student obj
		System.out.println("Create the student obj...");
		Student student1 = new Student("Neor","Frigider","neor_frig@gmail.com","PLAP");
		// save student obj
		System.out.println("Savind the student object...");
		studentDAO.save(student1);
		// display id of the save student obj
		int theId = student1.getId();
		System.out.println("Saved the student. Generate id: " + theId);
		// retrive the student based on the id: primary key
		System.out.println("retrived the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		// display the student
		System.out.println("Find the student with id: " + theId + " : " + myStudent);

	}



	public void querForStudents(StudentDAO studentDAO){
		// get list of student
		List<Student> theStudents = studentDAO.findAll();

		// display list of student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}



	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Je");
		//display list of students
		for(Student student : theStudents){
			System.out.println(student);
		}
	}

}