package com.library.management.librarymanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

import com.library.management.librarymanager.models.Person;
import com.library.management.librarymanager.repositories.PersonRepository;

@Service
public class PersonService {
	 	@Autowired
	    private Validator validator;	
	 	
	 	@Autowired
	 	private PersonRepository personRepository;
	 	
	 	public Person createPerson(String name) {
	 		Person person = new Person();
	 		person.setName(name);
	 		isValidPerson(person);
	 		personRepository.save(person);
	 		return person;
	 	}
	 	
	 	public Person getPerson(Long id) {
	 		Person person = this.findPersonById(id);
	 		return person;
	 	}
	 	
	 	public Person findPersonById(Long personId) throws IllegalArgumentException  {
	 		Optional<Person> person = personRepository.findById(personId);
	 		Person foundPerson = person.orElseThrow(
	 			() -> new IllegalArgumentException("Person not found")
	 				);
	 		return foundPerson;

	 	}
	 	
	 	private void isValidPerson(Person person)  {
	 		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(person, "person");
	        validator.validate(person, bindingResult);

	        if (bindingResult.hasErrors()) {
	            throw new IllegalArgumentException("Validation failed");
	        }
	 	}
	 	

}
