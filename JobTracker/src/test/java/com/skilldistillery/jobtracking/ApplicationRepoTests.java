package com.skilldistillery.jobtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationRepoTests {
	@Autowired
	private ApplicationRepository repo;

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
		List<Application> application = repo.findByCompany("Garmin");
		assertEquals("Garmin", application.get(0).getCompany());
	}

}
