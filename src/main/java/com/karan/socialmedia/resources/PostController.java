package com.karan.socialmedia.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karan.socialmedia.entity.Post;
import com.karan.socialmedia.entity.User;
import com.karan.socialmedia.services.PostService;

@RestController
public class PostController {

//	Retrieve all posts for a User - GET /users/{id}/posts
//
//	Create a posts for a User - POST /users/{id}/posts
//
//	Retrieve details of a post - GET /users/{id}/posts/{post_id}

	@Autowired
	PostService postService;

	@GetMapping("/users/{id}/posts")
	public List<Post> getAllPostsOfUser(@PathVariable Integer id) {
		return postService.getAllPostsOfUser(id);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<HttpStatus> addPost(@PathVariable Integer id , @RequestBody Post post){
		return postService.addPost(id, post);
	}
	
	@GetMapping("/users/{id}/posts/{pid}")
	public String getPostStory(@PathVariable Integer id, @PathVariable Integer pid){
		return postService.getPostStory(id, pid);
	}
}
