package com.springboot.studentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.studentSystem.entity.Student;
import com.springboot.studentSystem.repository.StudentRepository;

@SpringBootApplication
public class StudentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method
		Student student1=new Student("Maly","Pavol","maly@gmail.com");
		studentRepository.save(student1);
		
		Student student2=new Student("Velky","Peter","velky@gmail.com");
		studentRepository.save(student2);
		
		Student student3=new Student("Dolny","Jozef","dolny@gmail.com");
		studentRepository.save(student3);
	}

}
