package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Contact;

public interface ContactService {
	public Contact createContact(Contact contact);
	public Contact readContact(int id);
	public List<Contact> findByName(String name);
	public List<Contact> indexContacts();
	public Contact updateContact(Contact contact);
	public boolean deleteContact(int id);
}
