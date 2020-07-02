package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonService {	
	public Person save(Person person);
	public Person findById(String id);
	public void deleteById(String id);
	public List<Person> findAll();
	public Person findByName(String name);
}
