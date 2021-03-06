package com.skilldistillery.jobtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.skilldistillery.jobtracker.repositories.UserRepository;
import com.skilldistillery.jpajobtracker.entities.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepoTests {
	@Autowired
	private UserRepository repo;

	@Test
	@DisplayName("Tests if repo is mapped correctly")
	public void test1() {
		Optional<User> userOpt = repo.findById(1);
		User user = null;
		if (userOpt.isPresent()) {
			user = userOpt.get();
		}
		assertEquals(1, user.getId());
	}
	@Test
	@DisplayName("Tests if repo findByUsername is functional")
	public void test2() {
		User user = repo.findByUsername("casey.e.asher@outlook.com");
		assertEquals("student", user.getRole());
	}

}
