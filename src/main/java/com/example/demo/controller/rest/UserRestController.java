package com.example.demo.controller.rest;

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
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.response.component.ResponseComponent;
import com.example.demo.response.entity.Response;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {
	// los controladores devulven dto y reciben dto, por lo tanto el model mapper s
	// usa en el controller
	@Autowired
	private ResponseComponent responseComponent;
	
	@Autowired
	private UserController userController;

	@ApiOperation(value = "Get user by id", notes = "")
	@GetMapping("/users/{id}")
	public ResponseEntity<Response> get(@PathVariable("id") String id) {
		responseComponent.setPayload(userController.get(id));
		return new ResponseEntity<Response>(responseComponent.getOutput(), HttpStatus.OK);
	}

	@ApiOperation(value = "Add user", notes = "")
	@PostMapping("/users")
	public ResponseEntity<Response> add(@Valid @RequestBody UserCreateDto userCreateDto) {
		responseComponent.setPayload(userController.add(userCreateDto));
		return new ResponseEntity<Response>(responseComponent.getOutput(), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete user by id", notes = "")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		userController.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Modify user by id", notes = "")
	@PutMapping("/users/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") String id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
		responseComponent.setPayload(userController.update(id, userUpdateDto));
		return new ResponseEntity<Response>(responseComponent.getOutput(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get all users", notes = "")
	@GetMapping("/users")
	public ResponseEntity<Response> findAll() {
		responseComponent.setPayload(userController.findAll());
		return new ResponseEntity<Response>(responseComponent.getOutput(), HttpStatus.OK);
	}

}