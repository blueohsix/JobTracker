package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {
//	@Autowired
//	private ApplicationRepository repo;
	

	@Override
	public Application createApplication(Application application) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application readApplication(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Application> findByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> indexApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application updateApplication(Application application) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteApplication(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
