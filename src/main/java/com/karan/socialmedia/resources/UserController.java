package com.karan.socialmedia.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karan.socialmedia.entity.User;
import com.karan.socialmedia.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userDao;

	// get all user
	@GetMapping("/users")
	public List<User> getAllUser() {
		return userDao.getAllUsers();
	}

	// get single user
	@GetMapping("/users/{id}")
	public Optional<User> getOneUser(@PathVariable Integer id) {
		return userDao.getOneUser(id);
	}

	@PostMapping("/users")
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
		return userDao.addUser(user);
	}

	@PutMapping("/users")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
		return userDao.updateUser(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userDao.deleteUser(id);
	}

}
