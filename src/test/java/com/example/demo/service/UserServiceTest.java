package com.example.demo.service;


import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository mockUserRepository;
	
	@Autowired
	private UserService userService;
	
	@Test
    void testFindById() throws UserNotFoundException {
		
		doReturn(Optional.of(getUser())).when(mockUserRepository).findById("utybfjslfjghywtqbviffnejsapjdw");
		User user = userService.findById("utybfjslfjghywtqbviffnejsapjdw");
	    assertEquals("utybfjslfjghywtqbviffnejsapjdw", user.getId());
    }
	
	@Test
    void testFindByIdNotFound() {
		
    }
	
	public User getUser() {
		User oneUser = new User();
		oneUser.setId("utybfjslfjghywtqbviffnejsapjdw");
		oneUser.setName("Cristian");
		oneUser.setSurname("Jaldin");
		oneUser.setUsername("cjaldin");
		oneUser.setPassword("1234");
		oneUser.setRoles(Arrays.asList("ADMIN", "BASIC"));
		return oneUser;
	}
}
