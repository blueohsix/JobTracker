package com.skilldistillery.jobtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpajobtracker.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	public List<Application> findByStudentId(int id);
}
