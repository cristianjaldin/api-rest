package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;

public interface UserService {	
	public User save(User person);
	public User findById(String id) throws UserNotFoundException;
	public void deleteById(String id) throws UserNotFoundException;
	public List<User> findAll();
	public User findByUsername(String username) throws UserNotFoundException;
}
