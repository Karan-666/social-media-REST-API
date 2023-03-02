package com.karan.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.socialmedia.entity.User;

@Service
public interface UserService {

	public List<User> getAllUsers();

	public Optional<User> getOneUser(Integer id);

	public ResponseEntity<HttpStatus> addUser(User user);

	public ResponseEntity<HttpStatus> updateUser(User user);

	public ResponseEntity<HttpStatus> deleteUser(Integer id);

}
