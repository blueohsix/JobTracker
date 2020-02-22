package com.skilldistillery.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.skilldistillery.jobtracker.repositories.ContactRepository;
import com.skilldistillery.jpajobtracker.entities.Contact;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ContactRepoTests {
	@Autowired
	private ContactRepository repo;

	@Test
	@DisplayName("Tests if repo is mapped correctly")
	public void test1() {
		Optional<Contact> contactOpt = repo.findById(1);
		Contact contact = null;
		if (contactOpt.isPresent()) {
			contact = contactOpt.get();
		}
		assertEquals(1, contact.getId());
	}
	@Test
	@DisplayName("Tests if repo findByName is functional")
	public void test2() {
		List<Contact> contacts = repo.findByName("Katie Bones");
		assertEquals("Katie Bones", contacts.get(0).getName());
	}

}
