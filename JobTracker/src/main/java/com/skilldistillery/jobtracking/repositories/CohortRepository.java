package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.Cohort;

public interface CohortRepository extends JpaRepository<Cohort, Integer> {
	@Query(value="SELECT c From Cohort c WHERE c.name LIKE %:name%")
	public List<Cohort> findByName(@Param("name")String cohortName);
	
	

}
