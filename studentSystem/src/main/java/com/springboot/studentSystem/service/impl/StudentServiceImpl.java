package com.springboot.studentSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.studentSystem.entity.Student;
import com.springboot.studentSystem.repository.StudentRepository;
import com.springboot.studentSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	//@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	
}
