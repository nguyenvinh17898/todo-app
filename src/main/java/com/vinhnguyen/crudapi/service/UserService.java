package com.vinhnguyen.crudapi.service;

import java.util.List;

import com.vinhnguyen.crudapi.entites.User;

public interface UserService {
	public List<User> findAll(String name, String email);
	
	public User save(User user);
	
	public User findById(int id);
	
	public void detele(int id);
}
aaa	