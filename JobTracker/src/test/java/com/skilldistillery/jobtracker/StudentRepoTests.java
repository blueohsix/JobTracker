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

import com.skilldistillery.jobtracker.repositories.StudentRepository;
import com.skilldistillery.jpajobtracker.entities.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepoTests {
	@Autowired
	private StudentRepository repo;

	@Test
	@DisplayName("Tests if repo is mapped correctly")
	public void test1() {
		Optional<Student> studentOpt = repo.findById(1);
		Student student = null;
		if (studentOpt.isPresent()) {
			student = studentOpt.get();
		}
		assertEquals(1, student.getId());
	}
	@Test
	@DisplayName("Tests if repo findByFirstName is functional")
	public void test2() {
		List<Student> students = repo.findByName("Casey");
		assertEquals(1 , students.size());
		assertEquals("Asher", students.get(0).getLastName());
	}

}
