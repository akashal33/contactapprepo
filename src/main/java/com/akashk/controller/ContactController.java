package com.akashk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akashk.entity.Contact;
import com.akashk.service.ContactService;



@RestController
@CrossOrigin
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/data")
	public String getData() {
		return "working...";
	}

	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {

		String result = null;

		result = contactService.saveContact(contact);
		return result;

	}

	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {

		List<Contact> contacts = null;

		contacts = contactService.getAllContacts();

		return contacts;
	}

	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable("contactId") int contactId) {

		Contact contact = null;

		contact = contactService.getContactById(contactId);

		return contact;

	}

	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {

		String result = null;
		
		result = contactService.updateContact(contact);
		return result;

	}

	@DeleteMapping("/contact/{contactId}")
	public List<Contact> deleteContact(@PathVariable("contactId") int contactId) {

		List<Contact> contacts = null;
		String check = null;
		check = contactService.deleteContact(contactId);
		
		if(check.equals(" contact deleted")) {
			contacts = getAllContacts();
		}
		
		return contacts;

	}

}
