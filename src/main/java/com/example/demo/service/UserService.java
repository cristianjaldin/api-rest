package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {	
	public User save(User person);
	public User findById(String id);
	public void deleteById(String id);
	public List<User> findAll();
	public User findByName(String name);
}
