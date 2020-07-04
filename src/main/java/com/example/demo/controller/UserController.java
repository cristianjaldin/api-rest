package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserGetDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	// // los controladores devulven dto y reciben dto, por lo tanto el model mapper
	// s usa en el controller
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserService userService;

	public UserGetDto get(String id) {
		UserGetDto userGetDto = convertToDto(userService.findById(id));
		return userGetDto;
	}

	public UserGetDto add(UserCreateDto userCreateDto) {
		User user = convertToEntity(userCreateDto);
		user.setCreationDate(new Date());
		return convertToDto(userService.save(user));
	}

	public void delete(String id) {
		userService.deleteById(id);
	}

	public UserGetDto update(String id, UserUpdateDto userUpdateDto) {
		User user = userService.findById(id);
		user.setName(userUpdateDto.getName());
		user.setSurname(userUpdateDto.getSurname());
		user.setRoles(userUpdateDto.getRoles());
		return convertToDto(userService.save(user));
	}

	public List<UserGetDto> findAll() {
		return userService.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private UserGetDto convertToDto(User user) {
		UserGetDto userGetDto = modelMapper.map(user, UserGetDto.class);
		return userGetDto;
	}

	private User convertToEntity(UserCreateDto userCreateDto) {
		User user = modelMapper.map(userCreateDto, User.class);
		return user;
	}

}