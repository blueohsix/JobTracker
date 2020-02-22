package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jpajobtracker.entities.Student;

public interface StudentService {
	// students are created in AuthServiceImpl from the AdminController
	public List<Student> indexStudents();

	public Student retrieveStudent(int id);

	public List<Student> findByName(String name);

	public Student updateStudent(Student student);

	public boolean deleteStudent(int id);
}
