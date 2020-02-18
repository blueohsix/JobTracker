package com.skilldistillery.jobtracking.services;

import java.security.Principal;

import com.skilldistillery.jobtracking.entities.User;

public interface AuthService {

	User register(User user, Principal principal);

}
