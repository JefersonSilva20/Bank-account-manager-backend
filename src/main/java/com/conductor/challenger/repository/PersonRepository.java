package com.conductor.challenger.repository;

import com.conductor.challenger.model.Person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

}
