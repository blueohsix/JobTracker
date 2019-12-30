package com.skilldistillery.jobtracking.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Application application;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("trackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		 em = emf.createEntityManager();
		 application = em.find(Application.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		application = null;
	}
	

	@Test
	@DisplayName("Tests if the application table is mapped correctly")
	void test() {
		assertEquals(1, application.getId());
		assertEquals("Garmin" , application.getCompany());
		assertEquals("Katie Bones", application.getContacts().get(0).getName());
	}


}
