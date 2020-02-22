package com.skilldistillery.jobtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpajobtracker.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	public List<Contact> findByName(String name);

}
