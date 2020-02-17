package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value="SELECT s From Student s WHERE s.firstName LIKE %:name% OR s.lastName LIKE %:name%")
	List <Student> findByName(@Param("name") String name);

}
