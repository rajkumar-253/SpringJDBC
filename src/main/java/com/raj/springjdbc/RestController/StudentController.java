package com.raj.springjdbc.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raj.springjdbc.DTO.Student;
import com.raj.springjdbc.Service.StudentInterface;

@RestController
public class StudentController {
	
	@Autowired
	public StudentInterface studentInterface;
	
	@PostMapping("createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentInterface.addStudent(student);
	}
	
	@DeleteMapping("deleteStudent/{id}")
	public Student deleteStudent(@PathVariable int id) {
		return studentInterface.deleteStudent(id);
	}
	
	@PutMapping("updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentInterface.updateStudent(student);
	}
	
	@GetMapping("findStudent/{id}")
	public Student findStudentById(@PathVariable int id) {
		return studentInterface.findStudentById(id);
	}
	
	@GetMapping("findAllStudents")
	public List<Student> getAllStudents() {
		return studentInterface.findAllStudents();
	}

}
