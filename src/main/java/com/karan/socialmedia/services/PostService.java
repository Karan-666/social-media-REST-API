package com.karan.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.socialmedia.entity.Post;
import com.karan.socialmedia.entity.User;

@Service
public interface PostService {
	
	public List<Post> getAllPostsOfUser(Integer id);

	public ResponseEntity<HttpStatus> addPost(Integer id, Post post);

	public String getPostStory(Integer id, Integer pid);

	
}
