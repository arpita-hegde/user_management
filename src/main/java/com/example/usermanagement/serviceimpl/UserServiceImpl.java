package com.example.usermanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.iservice.UserService;
import com.example.usermanagement.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository useRepository;

    @Override
    public User addUser(User user) {
    	return useRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return useRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return useRepository.findUserById(id);
    }

    @Override
    public User updateUserById(Long id, User user) {
    	user.setId(id);
        return useRepository.save(user);
    }

    @Override
    public ResponseEntity<?> deleteUserById(Long id) {
    	useRepository.deleteById(id);
    	 return ResponseEntity.ok().build();
    }
}
