package com.skilldistillery.jobtracking.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.services.AuthService;
import com.skilldistillery.jobtracking.services.CohortService;
import com.skilldistillery.jobtracking.services.UserService;

@RestController
@CrossOrigin({ "*", "http:localhost:4207" })
@RequestMapping("api/")
public class AdminController {
	@Autowired
	private AuthService authService;
	@Autowired
	private UserService userService;
	@Autowired
	private CohortService cohortService;

	// USER

	@PostMapping("register")
	public User createUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		user = authService.register(user);
		return user;
	}

	@PutMapping("user")
	public User updateUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return userService.updateUser(user, principal);
	}

	@GetMapping("user/{id}")
	public User readUser(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return userService.readUser(id);
	}

	@GetMapping("user")
	public List<User> indexUsers(HttpServletRequest request, HttpServletResponse response, Principal principal) {
		return userService.indexUsers();
	}

	@DeleteMapping("user/{id}")
	public boolean toggleUser(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return userService.toggleUser(id);
	}

	// COHORT
	@PostMapping("cohort")
	public Cohort createCohort(@RequestBody Cohort cohort, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		System.err.println(cohort);
		return cohortService.createCohort(cohort);
	}
	@GetMapping("cohort")
	public List<Cohort> readCohort( HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
			return cohortService.indexCohorts();
	}
	
	@GetMapping("cohort/{identifier}")
	public List<Cohort> readCohort(@PathVariable("identifier") String identifier, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
			return cohortService.findByName(identifier);
	}
	
	@PutMapping("cohort")
	public Cohort updateCohort(@RequestBody Cohort cohort, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return cohortService.updateCohort(cohort);
	}
	
	@DeleteMapping("cohort/{id}")
	public boolean deleteCohort(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return cohortService.deleteCohort(id);
	}
	

}
