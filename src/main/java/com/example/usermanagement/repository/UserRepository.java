package com.example.usermanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.entity.User;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserById(Long id);
    
}