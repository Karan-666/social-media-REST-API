package com.karan.socialmedia.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String story;

	// A user can do many post, and a post is connected to one user
	// Many Post can be done by -> One user
	// with Lazy, it will not try and fetch the details by itself (which can cause
	// another loop), unless we call Post or Get user
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore // getting post details, we don't need user details (cause loop) so used JsonIgnore
	private User user;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override // In the to string, don't select user or it'll create recursion like loop
	public String toString() {
		return "Post [id=" + id + ", story=" + story + "]";
	}

}
