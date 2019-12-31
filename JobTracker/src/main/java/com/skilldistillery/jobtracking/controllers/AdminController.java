package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.services.AuthService;

@RestController
@CrossOrigin({ "*", "http:localhost:4207" })
public class AdminController {
	@Autowired
	private AuthService service;
	
	@PostMapping("register/")
	public User createUser(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		user = service.register(user);
	    return user;
	}
	@PostMapping("register/student/")
	public Student createStudent(@RequestBody Student student,  HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		
		
		return student;
	}
	
	
}
