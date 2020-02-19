package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	public List<Application> findByStudentId(int id);
}
