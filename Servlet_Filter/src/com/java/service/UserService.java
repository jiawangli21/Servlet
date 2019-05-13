package com.java.service;

import java.util.List;

import com.java.entity.Page;
import com.java.entity.User;

public interface UserService {

	public boolean login(String username,String password);
	
	public void register(User user);
	
	public List<User> findAllUser(Page p);
	
	public void deleteUserById(int id);
	
	public List<User> findByName(String username);
	
	public User findById(int id);
	
	public void updateById(User user);
	
    public int countUser();
}
