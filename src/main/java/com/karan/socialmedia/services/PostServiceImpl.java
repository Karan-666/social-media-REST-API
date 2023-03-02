package com.karan.socialmedia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.karan.socialmedia.entity.Post;
import com.karan.socialmedia.entity.User;
import com.karan.socialmedia.exception.PostNotFoundException;
import com.karan.socialmedia.exception.UserNotFoundException;
import com.karan.socialmedia.repository.PostRepository;
import com.karan.socialmedia.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;

	@Override
	public List<Post> getAllPostsOfUser(Integer id) {

		Optional<User> userOptional = userRepo.findById(id);

		if (userOptional.isPresent() == false)
			throw new UserNotFoundException("id: " + id);

		return userOptional.get().getPosts();
		// return userObj.get().getPosts();

	}

	@Override
	public ResponseEntity<HttpStatus> addPost(Integer id, Post post) {
		
		Optional<User> userOptional = userRepo.findById(id);
		
		if (userOptional.isPresent() == false)
			throw new UserNotFoundException("id: " + id);
		
		post.setUser(userOptional.get()); // setting post to the user of given id
		// or User user = userOptional.get(); post.setUser(user);
		
		postRepo.save(post);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@Override
	public String getPostStory(Integer id, Integer pid) {
		
		Optional<User> userOptional = userRepo.findById(id);
		
		if (userOptional.isPresent() == false)
			throw new UserNotFoundException("The user with id: " + id+" is not found.");
		
		Optional<Post> postOptional = postRepo.findById(pid);
		
		if (postOptional.isPresent() == false)
			throw new PostNotFoundException("The post with id: " + id + " is not found.");
		
			return postOptional.get().getStory();
		
	}
}
