package com.cob.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cob.binding.ContactForm;
import com.cob.entity.ContactEntity;
import com.cob.interfaces.ContactService;
import com.cob.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String createContact(ContactForm contactForm) {
		ContactEntity contactEntity = new ContactEntity();

		BeanUtils.copyProperties(contactForm, contactEntity);

		contactEntity.setActiveSW(true);

		contactEntity = contactRepository.save(contactEntity);

		if (contactEntity.getContactId() > 0) {
			return "Contact Has Been Saved Completely";
		}

		return "Contact Has Not Been Saved Successfully";

	}

	@Override
	public List<ContactForm> deleteContact(int contactId) {
		contactRepository.deleteById(contactId);

		return displayContact();
	}

	@Override
	public ContactForm editContact(int contactId, ContactForm contactForm) {
		Optional<ContactEntity> contactEntity;

		contactEntity = contactRepository.findById(contactId);

		if (contactEntity.isPresent()) {
			ContactEntity contactTempEntity = contactEntity.get();
			contactTempEntity.setContactName(contactForm.getContactName());
			contactTempEntity.setContactEmail(contactForm.getContactEmail());
			contactTempEntity.setContactNumber(contactForm.getContactNumber());
			contactTempEntity.setActiveSW(contactForm.isActiveSW());
			contactTempEntity.setCreatedDate(contactForm.getCreatedDate());
			contactTempEntity.setModifiedDate(contactForm.getModifiedDate());

			contactTempEntity = contactRepository.save(contactTempEntity);
			ContactForm contactFormtoReturn = new ContactForm();
			BeanUtils.copyProperties(contactTempEntity, contactFormtoReturn);

			System.out.println(contactFormtoReturn);

			return contactFormtoReturn;
		}

		return null;
	}

	@Override
	public List<ContactForm> displayContact() {
		List<ContactForm> contactFormList = new ArrayList<>();
		List<ContactEntity> contactEntityList = contactRepository.findAll();

		for (ContactEntity entity : contactEntityList) {
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(entity, contactForm);
			contactFormList.add(contactForm);
			System.out.println("yo");
		}

		return contactFormList;
	}

	@Override
	public ContactEntity getContact(int contactId) {
		return contactRepository.findById(contactId).get();
	}
}
