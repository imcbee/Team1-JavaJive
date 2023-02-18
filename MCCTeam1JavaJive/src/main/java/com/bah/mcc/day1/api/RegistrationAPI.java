package com.bah.mcc.day1.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@Autowired
	RegistrationsRepository registrationsRepository;

	@GetMapping
	public Iterable<Registration> getAll() {
		return registrationsRepository.findAll();
	}

	@GetMapping("/{registrationId}")
	public Optional<Registration> getRegistrationById(@PathVariable("registrationId") long id) {
		

		return registrationsRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> createRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if(newRegistration.getId() != 0 ||
				newRegistration.getCustomerName() == null ||
				newRegistration.getEventId() == null ||
				newRegistration.getRegistration_date() == null ||
				newRegistration.getNotes() == null) {
			
			return ResponseEntity.badRequest().build();
			
		}
		
		newRegistration = registrationsRepository.save(newRegistration);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		
		ResponseEntity<?> response = ResponseEntity.created(location).build();		
		
		System.out.println("Post route is working.");
		return response;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRegistration(@PathVariable("id") long id, @RequestBody Registration updateRegistration, UriComponentsBuilder uri) {
		if(updateRegistration.getEventId() == null || 
				updateRegistration.getCustomerName() == null) {
			
			return ResponseEntity.badRequest().build();
			
		}
		
		updateRegistration = registrationsRepository.save(updateRegistration);
		
		System.out.println("Put route is working");
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRegistration(@PathVariable("id") long id, UriComponentsBuilder uri) {
		
		registrationsRepository.deleteById(id);
		
		System.out.println("Delete route is working");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
	
	
	
	
}
