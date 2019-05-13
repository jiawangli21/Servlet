package com.java.dao;

import java.util.List;

import com.java.entity.Page;
import com.java.entity.User;

public interface UserDao {

	public User login(String username,String password);
	
	public void Register(User user);
	
	public List<User> findAllUser(Page p);
	
	public void deleteUserById(int id);
	
	public List<User> findByName(String username);
	
	public void updateById(User user);
	
	public int countUser();
}
