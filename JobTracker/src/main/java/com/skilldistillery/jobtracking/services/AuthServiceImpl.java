package com.skilldistillery.jobtracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.StudentRepository;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public User register(User user) {
			try {
				user.setEnabled(true);
				if(user.getRole().equalsIgnoreCase("student")) {
					user.setPassword(encoder.encode("getSkilled"));
					User savedUser = userRepo.saveAndFlush(user);
					Student newStudent = new Student();
					newStudent.setEmail(user.getUsername());
					newStudent.setUser(savedUser);
					Student savedStudent = studentRepo.saveAndFlush(newStudent);
					System.out.println(savedStudent);
					return savedUser;
				}
				if(user.getRole().equalsIgnoreCase("admin")) {
					user.setPassword(encoder.encode("giveSkills"));
					User savedUser = userRepo.saveAndFlush(user);
					return savedUser;
				}
			} catch (Exception e) {
				System.err.println("failed to register user: " + user);
				return user;
			}
			return null;
			
	}
	


}
