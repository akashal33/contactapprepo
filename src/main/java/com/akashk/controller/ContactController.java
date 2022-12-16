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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api("This is contact rest controller")
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@ApiOperation("This method used for saveing new contact")
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {

		String result = null;

		result = contactService.saveContact(contact);
		return result;

	}
	
	@ApiOperation("This method used for getting all contacts")
	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {

		List<Contact> contacts = null;

		contacts = contactService.getAllContacts();

		return contacts;
	}
	
	@ApiOperation("This method used for getting existing contact by id")
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable("contactId") int contactId) {

		Contact contact = null;

		contact = contactService.getContactById(contactId);

		return contact;

	}

	@ApiOperation("This method used for updating existing contact")
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {

		String result = null;

		result = contactService.updateContact(contact);
		return result;

	}
	
	@ApiOperation("This method used for deleting a contact")
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable("contactId") int contactId) {

		String result = null;

		result = contactService.deleteContact(contactId);
		return result;

	}

}
