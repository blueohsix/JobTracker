package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.repositories.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> indexStudents() {
		return repo.findAll();
	}

	@Override
	public Student readStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
