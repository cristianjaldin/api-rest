package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository personRepository;

	@Override
	public User save(User person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}
	
	@Override
	public User findById(String id) {	
		return personRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return personRepository.findAll();
	}

	@Override
	public User findByName(String name) {
		//TODO: exception not found
		return personRepository.findByName(name).get();
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		personRepository.deleteById(id);		
	}

}