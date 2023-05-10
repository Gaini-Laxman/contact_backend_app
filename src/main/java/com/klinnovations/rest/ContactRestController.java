package com.klinnovations.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klinnovations.binding.Contact;
import com.klinnovations.service.ContactService;

@RestController
@CrossOrigin
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	public ResponseEntity<String> createContact(@RequestBody Contact contact) {
	    try {
	        service.saveContact(contact); // tries to insert a duplicate email
	        return ResponseEntity.ok("Contact saved");
	    } catch (DataIntegrityViolationException e) {
	        return ResponseEntity.badRequest().body("Email already exists");
	        
	    }
	    
	    }
	

	

	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {
		return service.getAllContacts();
	}

	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}

	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}

	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
	    String deleted = service.deleteContactById(contactId);
	    if (deleted != null) {
	        return "Contact with ID " + contactId + " deleted successfully";
	    } else {
	        throw new RuntimeException("Failed to delete contact with ID " + contactId);
	    }
	}

}
