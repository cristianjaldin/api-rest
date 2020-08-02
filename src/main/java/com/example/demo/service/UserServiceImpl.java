package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User person) {
		return userRepository.save(person);
	}

	@Override
	public User findById(String id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public void deleteById(String id) throws UserNotFoundException {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new UserNotFoundException();
		}
	}

}