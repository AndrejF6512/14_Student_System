package com.springboot.studentSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.studentSystem.entity.Student;
import com.springboot.studentSystem.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	//@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	@GetMapping("/student/new")
	public String createStudentForm(Model model)
	{
		Student student=new Student();
		model.addAttribute("student", student);
		return "createStudent";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editStudent"; 
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model)
	{
		Student existingStudent =studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students"; 
	}
}
