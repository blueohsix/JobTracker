package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
	public Application findByCompany(String company);
}
