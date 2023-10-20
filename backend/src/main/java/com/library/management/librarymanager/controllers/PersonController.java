package com.library.management.librarymanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.librarymanager.models.Person;
import com.library.management.librarymanager.repositories.PersonRepository;
import com.library.management.librarymanager.services.PersonService;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	private final PersonService personService;
		
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addNewPerson(@RequestParam String name) {
		
		try {
			personService.createPerson(name);
		} catch (Exception exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
		

		return ResponseEntity.status(HttpStatus.CREATED).body("Person successfully saved.");
	}
	
	@GetMapping(path="/list")
	public @ResponseBody Iterable<Person> getAllPeople() {
		return personRepository.findAll();
	}
	

}
