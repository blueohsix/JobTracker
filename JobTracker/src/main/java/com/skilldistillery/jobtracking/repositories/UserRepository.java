package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
	
}
