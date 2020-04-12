package com.conductor.challenger.controller;


import java.util.Optional;

import javax.validation.Valid;

import com.conductor.challenger.model.Person;
import com.conductor.challenger.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("persons")
	public Page<Person> getPersons(Pageable pageable) {
		return this.personService.getPersonRepository().findAll(pageable);
	}

	@GetMapping("persons/{id}")
	public Optional<Person> getPersonOne(@PathVariable @Valid int id) {
		return this.personService.getPersonRepository().findById(id);
	}

}
