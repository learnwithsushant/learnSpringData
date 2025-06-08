package com.crudsample.UdemyCrudWorks;

import com.crudsample.UdemyCrudWorks.entity.Student;
import com.crudsample.UdemyCrudWorks.entity.dao.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UdemyCrudWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyCrudWorksApplication.class, args);
	}

	Logger LOG  = LoggerFactory.getLogger(UdemyCrudWorksApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return commandLineRunner -> {
			//createStudent(studentDao);
			readStudent(studentDao);
		};
	}

	private void readStudent(StudentDao studentDao) {
		System.out.println("Creating a new Student obj");
		Student astudent = new Student("Chaitrali","Wadjikar","wadjikarchaitrali@gmail.com");
		// save the student object
		System.out.println("Saving a new Student obj");
		studentDao.save(astudent);
		// display the student's id that got generated
		int id = astudent.getId();
		System.out.println("Getting the students id: "+id);
		// retrieving new record
		Student student = studentDao.findById(id);
		System.out.println("Student fetched is >"+ student);


	}

	private void createStudent(StudentDao studentDao){

		// create a student object
		System.out.println("Creating a new Student obj");
		Student astudent = new Student("Chaitrali","Wadjikar","wadjikarchaitrali@gmail.com");
		// save the student object
		System.out.println("Saving a new Student obj");
		studentDao.save(astudent);
		// display the student's id that got generated
		System.out.println("Getting the students id: "+astudent.getId());

		/**/
	}

}
