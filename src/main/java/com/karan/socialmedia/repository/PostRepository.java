package com.karan.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karan.socialmedia.entity.Post;
import com.karan.socialmedia.entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
