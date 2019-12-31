package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.User;

public interface UserService {
	public User createUser(User user);
	public User readUser(int id);
	public User findByUserName(String username);
	public List<User> indexUsers();
	public User updateUser(User user);
	public boolean deleteUser(int id);

}
