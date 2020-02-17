package com.skilldistillery.jobtracking.services;

import java.security.Principal;
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
	public User updateUser(User user, Principal principal) {
		Optional<User> userOpt = userrepo.findById(user.getId());
		User updatedUser = null;
		if (userOpt.isPresent()) {
			updatedUser = userOpt.get();
			if (!user.getPassword().startsWith("$")) {
				updatedUser.setPassword(encoder.encode(user.getPassword()));
			}
			if (principal.toString().contains("Granted Authorities: admin")
					&& user.getUsername() != updatedUser.getUsername()) {
				updatedUser.setUsername(user.getUsername());
			}
			if (principal.toString().contains("Granted Authorities: admin")
					&& user.getRole() != updatedUser.getRole()) {
				updatedUser.setRole(user.getRole());
			}
			userrepo.saveAndFlush(updatedUser);
		}

		return updatedUser;
	}

	@Override
	public boolean toggleUser(int id) {
		Optional<User> user = userrepo.findById(id);
		User toggleUser = null;
		if (user.isPresent()) {
			toggleUser = user.get();
			toggleUser.setEnabled(!toggleUser.isEnabled());
			try {
				userrepo.saveAndFlush(toggleUser);
				return toggleUser.isEnabled();
			} catch (Exception e) {
				System.err.println(e);
				return toggleUser.isEnabled();
			}

		}
		System.err.println("Failed to toggle: " + user.toString());
		return false;
	}

}
