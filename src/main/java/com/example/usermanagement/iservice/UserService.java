package com.example.usermanagement.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.usermanagement.entity.User;


public interface UserService {

    User addUser(User user);

    List<User> getUsers();
    User getUserById(Long id);

    User updateUserById(Long id, User user);

    ResponseEntity<?> deleteUserById(Long id);
}
