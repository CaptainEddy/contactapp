package com.cob.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cob.binding.ContactForm;
import com.cob.entity.ContactEntity;
import com.cob.service.ContactServiceImpl;

@RestController
public class ContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	@PostMapping(path = "/save")
	public String saveContact(@RequestBody ContactForm contactForm) {
		String status = null;
		status = contactServiceImpl.createContact(contactForm);

		return status;
	}

	@GetMapping(path = "/showContacts")
	public List<ContactForm> viewContacts() {

		System.out.println("INSIDE  -View Contacts");

		return contactServiceImpl.displayContact();
	}

	@DeleteMapping(path = "/deleteContact/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable int contactId) {
		return contactServiceImpl.deleteContact(contactId);
	}

	@PostMapping(path = "/editContact/{contactId}")
	public ContactForm editContact(@PathVariable int contactId, @RequestBody ContactForm contactForm) {
		return contactServiceImpl.editContact(contactId, contactForm);
	}

	@GetMapping(path = "/getContact/{contactId}")
	public ContactEntity getContact(@PathVariable int contactId) {
		return contactServiceImpl.getContact(contactId);
	}
}
