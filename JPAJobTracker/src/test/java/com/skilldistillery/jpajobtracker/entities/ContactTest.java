package com.skilldistillery.jpajobtracker.entities;

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

import com.skilldistillery.jpajobtracker.entities.Contact;

class ContactTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Contact contact;

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
		 contact = em.find(Contact.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		contact = null;
	}
	

	@Test
	@DisplayName("Tests if the contact table is mapped correctly")
	void test() {
		assertEquals(1, contact.getId());
		assertEquals("Katie Bones" , contact.getName());
		assertEquals("Garmin" , contact.getApplication().getCompany());
	}


}
