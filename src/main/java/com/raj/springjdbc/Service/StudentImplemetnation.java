package com.raj.springjdbc.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.springjdbc.DTO.Student;
import com.raj.springjdbc.Repo.StudentRepo;

@Service
public class StudentImplemetnation implements StudentInterface{
	
	public StudentRepo studentRepo;
	
	public StudentImplemetnation(StudentRepo studentRepo) {
		this.studentRepo=studentRepo;
	}

	@Override
	public Student addStudent(Student student) {
		studentRepo.addStudent(student);
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		return studentRepo.deleteStudent(id);
	}

	@Override
	public Student findStudentById(int id) {
		return studentRepo.findStudentById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.updateStudent(student);
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepo.getAllStudents();
	}

}
