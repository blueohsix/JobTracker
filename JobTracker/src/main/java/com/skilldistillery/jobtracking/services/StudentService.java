package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public Student readStudent(int id);
	public List <Student> findByName(String name);
	public List<Student> indexStudents();
	public Student updateStudent(Student student);
	public boolean deleteStudent(int id);
}
