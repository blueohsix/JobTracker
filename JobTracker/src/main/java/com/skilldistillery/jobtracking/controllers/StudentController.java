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

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.services.ApplicationService;
import com.skilldistillery.jobtracking.services.StudentService;

@RestController
@CrossOrigin({ "*", "http:localhost:4207" })
@RequestMapping("api/")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ApplicationService applicationService;

	@GetMapping("me/{studentId}/")
	public Student getMe(@PathVariable("studentId") int id, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return studentService.retrieveStudent(id);
	}
	@PutMapping("me/student")
	public Student updateStudent(@RequestBody Student student, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return studentService.updateStudent(student);
	}

	@PostMapping("me/{studentId}/application")
	public Application createApplication(@PathVariable("studentId") int id, @RequestBody Application application,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {
		return applicationService.createApplication(application, studentService.retrieveStudent(id));
	}

	@GetMapping("me/{applicationId}")
	public Application retrieveApplication(@PathVariable("applicationId") int id, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		return applicationService.retrieveApplication(id);
	}

	@GetMapping("me/{studentId}/applications")
	public List<Application> retrieveApplications(@PathVariable("studentId") int id, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		return applicationService.findByStudent(id);
	}

	@GetMapping("me/{studentId}/{company}")
	public List<Application> retrieveByCompany(@PathVariable("studentId") int id,
			@PathVariable("company") String company, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return applicationService.findByCompany(company, studentService.retrieveStudent(id));
	}
	@PutMapping("me/applications")
	public Application updateApplication(@RequestBody Application application, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return applicationService.updateApplication(application);
	}
	@DeleteMapping("me/application/{applicationId}")
	public Boolean deleteApplication(@PathVariable("applicationId") int id, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		return applicationService.deleteApplication(id);
	}

}
