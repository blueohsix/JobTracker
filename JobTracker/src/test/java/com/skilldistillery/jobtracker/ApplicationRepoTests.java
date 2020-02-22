package com.skilldistillery.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.skilldistillery.jobtracker.repositories.ApplicationRepository;
import com.skilldistillery.jobtracker.services.ApplicationService;
import com.skilldistillery.jpajobtracker.entities.Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationRepoTests {
	@Autowired
	private ApplicationRepository repo;
	@Autowired
	private ApplicationService applicationService;

	@Test
	@DisplayName("Tests if repo is mapped correctly")
	public void test1() {
		Optional<Application> applicationOpt = repo.findById(1);
		Application application = null;
		if (applicationOpt.isPresent()) {
			application = applicationOpt.get();
		}
		assertEquals(1, application.getId());
	}
	@Test
	@DisplayName("Tests if repo is functional")
	public void test2() {
		
		List <Application> applicationsByStudent = applicationService.findByStudent(1);
		List <Application> applicationsFromCompany = new ArrayList<Application>();
		for (int i = 0; i < applicationsByStudent.size(); i++) {
			if(applicationsByStudent.get(i).getCompany().equalsIgnoreCase("Garmin")) {
				applicationsFromCompany.add(applicationsByStudent.get(i));
			}
		}
		assertEquals("Garmin", applicationsFromCompany.get(0).getCompany());
	}

}
