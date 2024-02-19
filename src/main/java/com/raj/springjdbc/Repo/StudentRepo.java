package com.raj.springjdbc.Repo;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raj.springjdbc.DTO.Student;

@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbcTemplate;
	
	private static String insert="insert into student (id,firstName,lastName,age,email) values (?,?,?,?,?)";
	private static String update="update student set firstName=?,lastName=?,age=?,email=? where id=?";
	private static String delete="delete from student where id=?";
	private static String findId="select * from student where id=?";
	private static String findAll="select * from student";
	
	public StudentRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public Student addStudent(Student student) {
//		//Student s1=new Student(student.getId(),student.getFirstName(),student.getLastName(),student.getAge(),student.getEmail());
//		studentsList.add(student);
		int update2 = jdbcTemplate.update(insert, student.getId(),student.getFirstName(),student.getLastName(),student.getAge(),student.getEmail());
		return student;
	}
	
	public Student deleteStudent(int id) {
		Student deletestudent=findStudentById(id);
//		studentsList.remove(deletestudent);
		jdbcTemplate.update(delete,id);
		return deletestudent;
	}
	public Student findStudentById(int id) {
//		for(Student student:studentsList) {
//			if(student.getId()==id) {
//				return student;
//			}
//		}
		Student st=jdbcTemplate.queryForObject(findId,new BeanPropertyRowMapper<Student>(Student.class),id);
		return st;
	}
	
	public Student updateStudent(Student student) {
//		int updateStudent=student.getId();
//		studentsList.set(updateStudent, student);
		jdbcTemplate.update(update,student.getFirstName(),student.getLastName(),student.getAge(),student.getEmail(), student.getId());
		return student;
	}
	public List<Student> getAllStudents(){
		return jdbcTemplate.query(findAll, new BeanPropertyRowMapper(Student.class));
	}

}
