package com.example.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/user")
	public @ResponseBody User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/users")
	public @ResponseBody List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public @ResponseBody User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/users/{id}")
	public @ResponseBody User updateUserById(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}

	@DeleteMapping("/users/{id}")
	public @ResponseBody ResponseEntity<?> deleteUserById(@PathVariable Long id) {
		return userService.deleteUserById(id);
	}

}
