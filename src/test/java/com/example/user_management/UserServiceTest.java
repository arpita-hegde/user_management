package com.example.user_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.usermanagement.controller.UserController;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.serviceimpl.UserServiceImpl;

public class UserServiceTest {
	
	@InjectMocks
	UserController userController;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}
	
	 @Test
	   public void addUserTest(){
		
		 User user = User.builder().id(1L).firstName("ajna").lastName("pran").build();
		
		 
		when(userRepository.save(user)).thenReturn(user);
		 
		 User addUser = userServiceImpl.addUser(user);
		 assertEquals(user, addUser);
		 
	 }

	
	 @Test
	   public void getUserTest(){
		 List<User> users = new ArrayList<>();
		 User user = User.builder().id(1L).firstName("ajna").lastName("pran").build();

		 users.add(user);
		 
		when(userRepository.findAll()).thenReturn(users);
		 
		 List<User> userList = userServiceImpl.getUsers();
		 assertEquals(users.size(), userList.size());
		 
	 }
	 
	 @Test
	   public void getUsersByIdTest(){
		
		 User user = User.builder().id(1L).firstName("ajna").lastName("pran").build();

		 
		when(userRepository.findUserById(1L)).thenReturn(user);
		 
		 User addUser = userServiceImpl.getUserById(1L);
		 assertEquals(user, addUser);
		 
	 }
	 
	 @Test
	   public void updateUserByIdByIdTest(){
		
		 User user = User.builder().id(1L).firstName("ajna").lastName("pran").build();

		 
		when(userRepository.save(user)).thenReturn(user);
		 
		 User addUser = userServiceImpl.updateUserById(1L, user);
		 assertEquals(user, addUser);
		 
	 }

//	 @Test
//	   public void deleteUserByIdByIdTest(){
//		
//		 User user = new User();
//		 user.setAge("22");
//		 user.setId(1L);
//		 user.setFirstName("ajna");
//		 user.setLastName("rai");
//		 
//		
//		 
//		ResponseEntity<?> response  = userServiceImpl.deleteUserById(1L);
//		verify(userRepository).deleteById(1L);
//		 assertEquals("200", response);
//		 
//	 }
}
