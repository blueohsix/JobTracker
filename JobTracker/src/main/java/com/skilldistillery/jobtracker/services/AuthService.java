package com.skilldistillery.jobtracker.services;

import java.security.Principal;

import com.skilldistillery.jpajobtracker.entities.User;

public interface AuthService {

	User register(User user, Principal principal);

}
