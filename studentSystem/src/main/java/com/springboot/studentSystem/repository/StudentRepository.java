package com.springboot.studentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.studentSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
