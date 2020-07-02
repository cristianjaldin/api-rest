package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	public Optional<Person> findByName(String name);
	
}
