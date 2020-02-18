package com.skilldistillery.jobtracking.services;

import java.security.Principal;
import java.util.List;

import com.skilldistillery.jobtracking.entities.User;

public interface UserService {
	public User readUser(int id);

	public User findByUserName(String username);

	public List<User> indexUsers();

	public User updateUser(User user, Principal principal);

	public boolean toggleUser(int id);

}
