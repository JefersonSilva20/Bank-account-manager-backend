package com.conductor.challenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.challenger.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

}
