package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UserService userService;

	@Override
	public Student retrieveStudent(int id) {
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public List<Student> findByName(String studentName) {
		return studentRepo.findByName(studentName);

	}

	@Override
	public List<Student> indexStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> studentOpt = studentRepo.findById(student.getId());
		Student updatedStudent = null;
		try {
			if (studentOpt.isPresent()) {
				updatedStudent = student;
				return studentRepo.saveAndFlush(updatedStudent);
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		try {
			Student student = studentRepo.findById(id).get();
			userService.toggleUser(student.getId());
			return true;
		} catch (Exception e) {
			System.err.println("Student id " + id + " does not exist");
			return false;
		}

	}

}
