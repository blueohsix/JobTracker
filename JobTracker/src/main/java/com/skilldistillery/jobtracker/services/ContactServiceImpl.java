package com.skilldistillery.jobtracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpajobtracker.entities.Contact;


@Service
public class ContactServiceImpl implements ContactService{
//	@Autowired
//	private ContactRepository repo;

	@Override
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact readContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Contact> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> indexContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
