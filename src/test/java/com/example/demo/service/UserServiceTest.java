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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    private final static String USER_ID = "utybfjslfjghywtqbviffnejsapjdw";
    private final static String NONEXISTENT_USER_ID = "dfgfgfdgdfgdfgdfgdretertertret";
    
	@MockBean
	private UserRepository mockUserRepository;

	@Autowired
	private UserService userService;

	@Test
	void testFindById() throws UserNotFoundException {
		doReturn(Optional.of(getUser())).when(mockUserRepository).findById(USER_ID);
		User user = userService.findById(USER_ID);
		assertEquals(USER_ID, user.getId());
	}

	@Test
	void testFindByIdNotFound() {
		assertThrows(UserNotFoundException.class, () -> {
			userService.findById(NONEXISTENT_USER_ID);
		});
	}

	public User getUser() {
		User oneUser = new User();
		oneUser.setId(USER_ID);
		oneUser.setName("Cristian");
		oneUser.setSurname("Jaldin");
		oneUser.setUsername("cjaldin");
		oneUser.setPassword("1234");
		oneUser.setRoles(Arrays.asList("ADMIN", "BASIC"));
		return oneUser;
	}
}
