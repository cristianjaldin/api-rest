package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Get a person by id", notes =  "")
	@GetMapping("/person/{id}")
	public Person get(@PathVariable("id") String id) {
		return personService.findById(id);
	}
	
	@ApiOperation(value = "Add a person to the person collection", notes =  "")
	@PostMapping("/person")
	public Person add(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@ApiOperation(value = "Delete a person by id", notes =  "")
	@DeleteMapping("/person/{id}")
	public void delete(@PathVariable("id") String id) {
		personService.deleteById(id);
	}
	
	@ApiOperation(value = "Get all person", notes =  "")
	@DeleteMapping("/person")
	public List<Person> findAll() {
		return personService.findAll();
	}
	
}