package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.Student;

public interface ApplicationService {
	public Application createApplication(Application application, Student student);

	public Application retrieveApplication(int id);
	
	public List<Application> findByStudent(int id);

	public List<Application> findByCompany(String company, Student student);

	public Application updateApplication(Application application);

	public boolean deleteApplication(int id);

}
