package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Application;

public interface ApplicationService {
	public Application createApplication(Application application);
	public Application readApplication(int id);
	public List<Application> findByCompany(String company);
	public List<Application> indexApplications();
	public Application updateApplication(Application application);
	public boolean deleteApplication(int id);

}
