package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	public List<Contact> findByName(String name);
	
}
