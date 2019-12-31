package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User findByUserName(String username) {
		return userrepo.findByUsername(username);
	}

	@Override
	public List<User> indexUsers() {
		return userrepo.findAll();
	}

	@Override
	public User readUser(int id) {
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}

	@Override
	public User createUser(User user) {
		return userrepo.saveAndFlush(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userOpt = userrepo.findById(user.getId());
		User updatedUser = null;
		if (userOpt.isPresent()) {
			updatedUser = userOpt.get();
			if (user.getPassword() != null) {
				updatedUser.setPassword(encoder.encode(user.getPassword()));
			}
			if (user.getUsername() != null) {
				updatedUser.setUsername(user.getUsername());
			}
			userrepo.saveAndFlush(updatedUser);
		}

		return updatedUser;
	}

	@Override
	public boolean deleteUser(int id) {

		Optional<User> user = userrepo.findById(id);
		User disabledUser = null;
		if (user.isPresent()) {
			disabledUser = user.get();
			disabledUser.setEnabled(!disabledUser.isEnabled());
			userrepo.saveAndFlush(disabledUser);
			System.err.println(disabledUser.getUsername() + " disabled successfully");
			return true;
		}
		System.err.println("Failed to disable: " + user.toString());
		return false;
	}

}
