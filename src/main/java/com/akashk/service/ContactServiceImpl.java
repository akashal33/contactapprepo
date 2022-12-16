package com.akashk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akashk.entity.Contact;
import com.akashk.repository.ContactRepository;



@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(Contact contact) {

		
		String result = null;
		contact.setActiveFlag(true);
		
		contact = contactRepo.save(contact);
		if (contact.getContactId() != null) {
			
			
			result = "contact saved successfully";
			
		} else {
			result = "contact not saved";
		}
		return result;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<Contact> contacts = null;

		//contacts = contactRepo.findAll();
		contacts = contactRepo.findByactiveFlag(true);
		return contacts;
	}

	@Override
	public Contact getContactById(int contactId) {

		Optional<Contact> contact = null;
		
		contact = contactRepo.findById(contactId);
		return contact.get();
	}

	@Override
	public String updateContact(Contact contact) {

		String result = null;
		
		
		
		if (contactRepo.existsById(contact.getContactId())) {
			contactRepo.save(contact);
			result = " contact updated ";
		} else {
			result = " contact not found ";
		}

		return result;
	}

	@Override
	public String deleteContact(int contactId) {
		
		String result = null;
		Optional<Contact> contactOp = null;
		Contact contact = null;
		
		/*
		 * if(contactRepo.existsById(contactId)) { contactRepo.deleteById(contactId);
		 * result = " contact deleted"; }else { result = " contact not found"; }
		 * 
		 * return result;
		 */
			
		 contactOp = contactRepo.findById(contactId);
		 if(contactOp.isPresent()) {
			 
			 contact = contactOp.get();
			 contact.setActiveFlag(false);
			 contactRepo.save(contact);
			 result = "contact deleted";
			 
		 }
		 else {
			 result = " contact not found";
		 }
		 
		return result;
	}

}
