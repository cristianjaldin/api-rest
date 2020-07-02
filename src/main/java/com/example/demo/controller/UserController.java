package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService personService;
	
	public User get(@PathVariable("id") String id) {
		return personService.findById(id);
	}
	
	public User add(@RequestBody User person) {
		return personService.save(person);
	}
	
	public void delete(@PathVariable("id") String id) {
		personService.deleteById(id);
	}
	
	public User update(@RequestBody User person) {
		return null;
	}
	
	public List<User> findAll() {
		return personService.findAll();
	}
	
}