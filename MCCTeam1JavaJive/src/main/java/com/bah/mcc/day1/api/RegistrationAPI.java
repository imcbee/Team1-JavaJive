package com.bah.mcc.day1.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.mcc.day1.domain.Registration;
import com.bah.mcc.day1.repository.RegistrationsRepository;

@RestController
@RequestMapping("/registrations")
public class RegistrationAPI {
	ArrayList<Registration> registrationList = new ArrayList<Registration>();
	
	@Autowired
	RegistrationsRepository registrationsRepository;

//	@SuppressWarnings("deprecation")
//	public RegistrationAPI() {
//		Registration r1 = new Registration(1L, "1", "2", new Date(), "please email me the event details");
//		Registration r2 = new Registration(2L, "2", "2", new Date(), "send transportation and hotel booking");
//		Registration r3 = new Registration(3L, "3", "3", new Date(), "defer payments for a week");
//		
//		registrationList.add(r1);
//		registrationList.add(r2);
//		registrationList.add(r3);
//	}

	@GetMapping
	public Collection<Registration> getAll() {
		return this.registrationList;
	}

	@GetMapping("/{registrationId}")
	public Registration getRegistrationById(@PathVariable("registrationId") long id) {
		
		Registration registration = null;
		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationList.get(i).getId() == id) {
				registration = registrationList.get(i);
			}
		}
		return registration;
	}
	
	@PostMapping
	public ResponseEntity<?> createRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if(newRegistration.getId() != 0 ||
				newRegistration.getCustomerName() == null ||
				newRegistration.getEventId() == null ||
				newRegistration.getRegistrationDate() == null ||
				newRegistration.getNotes() == null) {
			
			return ResponseEntity.badRequest().build();
			
		}
		
		newRegistration = registrationsRepository.save(newRegistration);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		
		ResponseEntity<?> response = ResponseEntity.created(location).build();		
		
		return response;
		
	}
//	
//	@PutMapping
//	public updateRegistration() {
//		
//	}
//	
//	@DeleteMapping
//	public deleteRegistration() {
//		
//	}
}
