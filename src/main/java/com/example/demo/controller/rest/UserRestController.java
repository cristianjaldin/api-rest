package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.UserController;
import com.example.demo.entity.User;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {

	@Autowired
	private UserController userController;
	
	@ApiOperation(value = "Get a person by id", notes = "")
	@GetMapping("/person/{id}")
	public User get(@PathVariable("id") String id) {
		return userController.get(id);
	}

	@ApiOperation(value = "Add a person to the person collection", notes = "")
	@PostMapping("/person")
	public User add(@RequestBody User person) {
		return userController.add(person);
	}

	@ApiOperation(value = "Delete a person by id", notes = "")
	@DeleteMapping("/person/{id}")
	public void delete(@PathVariable("id") String id) {
		userController.delete(id);
	}

	@ApiOperation(value = "Modify a person by id", notes = "")
	@PutMapping("/person/{id}")
	public User update(@RequestBody User person) {
		return userController.update(person);
	}

	@ApiOperation(value = "Get all person", notes = "")
	@DeleteMapping("/person")
	public List<User> findAll() {
		return userController.findAll();
	}

}