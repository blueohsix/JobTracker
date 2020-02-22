package com.skilldistillery.jobtracker.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.repositories.ApplicationRepository;
import com.skilldistillery.jpajobtracker.entities.Application;
import com.skilldistillery.jpajobtracker.entities.Student;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepo;

	@Override
	public Application createApplication(Application application, Student student) {
		try {
			application.setStudent(student);
			return applicationRepo.saveAndFlush(application);
		} catch (Exception e) {
			System.err.println("Failed to create application: " + application);
			return null;
		}
	}

	@Override
	public Application retrieveApplication(int id) {
		Optional<Application> application = applicationRepo.findById(id);
		if (application.isPresent()) {
			return application.get();
		}
		System.err.println("No application by id " + id + " found");
		return null;
	}
	
	@Override
	public List<Application> findByStudent(int id) {
		try {
			return applicationRepo.findByStudentId(id);
		}
		catch(Exception e) {
			System.err.println("Failed to retrieve applications for student id: " + id);
			return null;
		}
	}

	@Override
	public List<Application> findByCompany(String companyName, Student student) {
		List <Application> applicationsByStudent = this.findByStudent(student.getId());
		List <Application> applicationsFromCompany = new ArrayList<Application>();
		for (int i = 0; i < applicationsByStudent.size(); i++) {
			if(applicationsByStudent.get(i).getCompany().equalsIgnoreCase(companyName)) {
				applicationsFromCompany.add(applicationsByStudent.get(i));
			}
		}
		return applicationsFromCompany;

	}

	@Override
	public Application updateApplication(Application application) {
		Optional<Application> applicationOpt = applicationRepo.findById(application.getId());
		Application updatedApplication = null;
		try {
			if (applicationOpt.isPresent()) {
				updatedApplication = application;
				return applicationRepo.saveAndFlush(updatedApplication);
			} else {
				System.err.println("No application by id " + application.getId() + " found to update");
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public boolean deleteApplication(int id) {
		try {
			applicationRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Application id " + id + " does not exist");
			return false;
		}

	}

}
