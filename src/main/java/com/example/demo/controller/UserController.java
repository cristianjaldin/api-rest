package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService personService;
	
	@ApiOperation(value = "Get a person by id", notes =  "")
	@GetMapping("/person/{id}")
	public User get(@PathVariable("id") String id) {
		return personService.findById(id);
	}
	
	@ApiOperation(value = "Add a person to the person collection", notes =  "")
	@PostMapping("/person")
	public User add(@RequestBody User person) {
		return personService.save(person);
	}
	
	@ApiOperation(value = "Delete a person by id", notes =  "")
	@DeleteMapping("/person/{id}")
	public void delete(@PathVariable("id") String id) {
		personService.deleteById(id);
	}
	
	@ApiOperation(value = "Modify a person by id", notes =  "")
	@PutMapping("/person/{id}")
	public User update(@RequestBody User person) {
		return null;
	}
	
	@ApiOperation(value = "Get all person", notes =  "")
	@DeleteMapping("/person")
	public List<User> findAll() {
		return personService.findAll();
	}
	
}