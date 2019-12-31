package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({ "*", "http:localhost:4207" })
public class AuthController {
	
// *only 'admin' role users can create students and other admins* 
	
//	@RequestMapping(path = "/register", method = RequestMethod.POST)
//	public User register(@RequestBody User user, HttpServletResponse res) {
//		if (user == null) {
//			res.setStatus(400);
//			return null;
//		}
//		user = service.register(user);
//		return user;
//	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.GET)
	public Principal authenticate(Principal principal) {
		return principal;
	}

}
