package com.skilldistillery.jobtracking.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.CohortRepository;
import com.skilldistillery.jobtracking.repositories.StudentRepository;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CohortRepository cohortRepo;
	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user, Principal principal) {
		User savedUser;
		Student newStudent = new Student();
		Student savedStudent;
		try {
			if (userRepo.findByUsername(user.getUsername()) != null) {
				System.err.println(user.getUsername() + " already exists");
				return null;
			}
			if (principal.toString().contains("@skilldistillery.com")
					&& principal.toString().contains("Granted Authorities: admin")) {
				user.setEnabled(true);
				if (user.getRole().equalsIgnoreCase("student")) {
					user.setPassword(encoder.encode("getSkilled"));
					newStudent.setEmail(user.getUsername());
					newStudent.setFirstName("Replace Me");
					newStudent.setLastName("Replace Me");
					newStudent.setCohort(cohortRepo.findByName("SD-Unassigned").get(0));
					savedUser = userRepo.saveAndFlush(user);
					newStudent.setUser(savedUser);
					savedStudent = studentRepo.saveAndFlush(newStudent);
					savedUser.setStudent(savedStudent);
					userService.updateUser(savedUser, principal);
					return savedUser;
				}
				if (user.getRole().equalsIgnoreCase("admin")) {
					user.setPassword(encoder.encode("giveSkills"));
					savedUser = userRepo.saveAndFlush(user);
					return savedUser;
				}
			}
		} catch (Exception e) {
			System.err.println("failed to register user: " + user
					+ " | or failed to register student with user information: " + user);
			return user;
		}
		return null;

	}

}
