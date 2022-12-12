package com.akashk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akashk.entity.Contact;


@Service
public interface ContactService {
	
	public String saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(int contactId);
	public String updateContact(Contact contact);
	public String deleteContact(int contactId);

}
