package com.skilldistillery.jobtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.CohortRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CohortRepoTests {
	@Autowired
	private CohortRepository repo;

	@Test
	@DisplayName("Tests if repo is mapped correctly")
	public void test1() {
		Optional<Cohort> cohortOpt = repo.findById(1);
		Cohort cohort = null;
		if (cohortOpt.isPresent()) {
			cohort = cohortOpt.get();
		}
		assertEquals(1, cohort.getId());
	}
	@Test
	@DisplayName("Tests if repo findByName is functional")
	public void test2() {
		Cohort cohort = repo.findByName("SD22");
		assertEquals("2019-07-08" , cohort.getStartDate().toString());
	}

}
