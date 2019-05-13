package com.java.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.java.dao.FindUserByIdDao;
import com.java.dao.UserDao;
import com.java.dao.impl.FindUserByIdDaoImpl;
import com.java.dao.impl.UserDaoImpl;
import com.java.entity.Page;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.tool.JDBCUtils;

public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) {
	    UserDao dao = new UserDaoImpl();
	    boolean bool = false;
	    User user = dao.login(username, password);
	    if(user != null){
	    	bool = true;
	    }
		return bool;
	}
	@Override
	public void register(User user) {
		Connection conn = null;
		UserDao dao = new UserDaoImpl();
		conn = JDBCUtils.getConnetcion();
		try {
			conn.setAutoCommit(false);
			dao.Register(user);
			conn.commit();
			JDBCUtils.close(conn, null);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	@Override
	public List<User> findAllUser(Page p) {
		UserDao dao = new UserDaoImpl();
		return dao.findAllUser(p);
	}
	@Override
	public void deleteUserById(int id) {
		Connection conn = null;
		UserDao dao = new UserDaoImpl();
		conn = JDBCUtils.getConnetcion();
		try {
			conn.setAutoCommit(false);
			dao.deleteUserById(id);
			conn.commit();
			JDBCUtils.close(conn, null);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	@Override
	public List<User> findByName(String username) {
		UserDao dao = new UserDaoImpl();
		return dao.findByName(username);
	}
	
	@Override
	public void updateById(User user) {
		Connection conn = null;
		UserDao dao = new UserDaoImpl();
		conn = JDBCUtils.getConnetcion();
		try {
			conn.setAutoCommit(false);
			dao.updateById(user);
			conn.commit();
			JDBCUtils.close(conn, null);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	@Override
	public User findById(int id) {
		FindUserByIdDao dao = new  FindUserByIdDaoImpl();
		return dao.findById(id);
	}
	@Override
	public int countUser() {
		UserDao dao = new UserDaoImpl();
		return dao.countUser();
	}


}
