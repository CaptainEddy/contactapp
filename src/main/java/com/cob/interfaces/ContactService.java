package com.cob.interfaces;

import java.util.List;
import com.cob.binding.ContactForm;
import com.cob.entity.ContactEntity;

public interface ContactService {
	public String createContact(ContactForm contactForm);

	public List<ContactForm> deleteContact(int contactId);

	public ContactForm editContact(int contactId, ContactForm contactForm);

	public List<ContactForm> displayContact();
	
	public ContactEntity getContact(int contactId);
}
