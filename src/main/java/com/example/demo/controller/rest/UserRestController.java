package com.example.demo.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.UserController;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserGetDto;
import com.example.demo.dto.user.UserUpdateDto;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {
	// los controladores devulven dto y reciben dto, por lo tanto el model mapper s
	// usa en el controller
	@Autowired
	private UserController userController;

	@ApiOperation(value = "Get user by id", notes = "")
	@GetMapping("/users/{id}")
	public ResponseEntity<UserGetDto> get(@PathVariable("id") String id) {
		return new ResponseEntity<UserGetDto>(userController.get(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Add user", notes = "")
	@PostMapping("/users")
	public ResponseEntity<UserGetDto> add(@Valid @RequestBody UserCreateDto userCreateDto) {
		return new ResponseEntity<UserGetDto>(userController.add(userCreateDto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete user by id", notes = "")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		userController.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Modify user by id", notes = "")
	@PutMapping("/users/{id}")
	public ResponseEntity<UserGetDto> update(@PathVariable("id") String id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
		return new ResponseEntity<UserGetDto>(userController.update(id, userUpdateDto), HttpStatus.OK);
	}

	@ApiOperation(value = "Get all users", notes = "")
	@GetMapping("/users")
	public ResponseEntity<List<UserGetDto>> findAll() {
		return new ResponseEntity<List<UserGetDto>>(userController.findAll(), HttpStatus.OK);
	}

}