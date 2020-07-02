package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}
	
	@Override
	public Person findById(String id) {	
		return personRepository.findById(id).get();
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findByName(String name) {
		//TODO: exception not found
		return personRepository.findByName(name).get();
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);		
	}

}