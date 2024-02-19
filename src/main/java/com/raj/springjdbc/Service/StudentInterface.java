package com.raj.springjdbc.Service;

import java.util.List;

import com.raj.springjdbc.DTO.Student;

public interface StudentInterface {
	
	public Student addStudent(Student student);
	public Student deleteStudent(int id);
	public Student findStudentById(int id);
	public Student updateStudent(Student student);
	public List<Student> findAllStudents();

}
