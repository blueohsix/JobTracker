package com.skilldistillery.jobtracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public User register(User user) {
			String encryptedPassword = encoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			user.setEnabled(true);
			if(user.getRole() == null) {
				user.setRole("student");
			}
			repo.saveAndFlush(user);
			
		return user;
	}


}
