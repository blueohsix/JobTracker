package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.services.StudentService;

@RestController
@CrossOrigin({ "*", "http:localhost:4207" })
@RequestMapping("api/")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("student/")
	public List<Student> indexStudents(HttpServletRequest request, HttpServletResponse response, Principal principal) {
		return studentService.indexStudents();
	}

}
