package com.karan.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.socialmedia.entity.User;
import com.karan.socialmedia.exception.UserNotFoundException;
import com.karan.socialmedia.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getOneUser(Integer id) {

		// optional type automatically handle exception in case of null output for user
		// (Object)
		// findById returns object in Optional<Obj> format.
		Optional<User> optionalUser = userRepo.findById(id);

		if (optionalUser.isPresent() == false) // isPresent() function is provided by optional class
			throw new UserNotFoundException("The id: " + id + " is not found in our database.");

		return optionalUser;

	}

	@Override
	public ResponseEntity<HttpStatus> addUser(User user) {

		userRepo.save(user);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HttpStatus> updateUser(User user) {

		Optional<User> userObj = userRepo.findById(user.getId());

		if (userObj.isPresent() == false)
			throw new UserNotFoundException("The id: " + user.getId() + " is not found in our database.");
		else {
			userRepo.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<HttpStatus> deleteUser(Integer id) {

		Optional<User> userObj = userRepo.findById(id);

		if (userObj.isPresent() == false)
			throw new UserNotFoundException("The id: " + id + " is not found in our database.");
		else {
			userRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

}
