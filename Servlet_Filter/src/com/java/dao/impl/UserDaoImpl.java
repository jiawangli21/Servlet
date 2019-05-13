package com.java.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.UserDao;
import com.java.entity.Page;
import com.java.entity.User;
import com.java.tool.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(String username,String password) {
	    String sql = "select * from t_user where name = ? and password = ?";
	    Connection conn = null;
	    ResultSet rs = null;
	    User user = null;
	    try {
	    	conn = JDBCUtils.getConnetcion();
			PreparedStatement pre  = conn.prepareStatement(sql);
			pre.setString(1,username);
			pre.setString(2, password);
			rs = pre.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setBirthday(rs.getDate(4));
			}
			JDBCUtils.close(conn, pre, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void Register(User user) {

        String sql = "insert into t_user values(userId.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pre = null;	
		try {
			conn = JDBCUtils.getConnetcion();
		    pre = conn.prepareStatement(sql);
		    pre.setString(1, user.getUsername());
		    pre.setString(2,user.getPassword());
		    pre.setDate(3, new Date(user.getBirthday().getTime()));
		    pre.executeUpdate();
		    JDBCUtils.close(null, pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> findAllUser(Page p) {
		String sql = "select * from (select t.*,Rownum r from t_user t) where r between ";
		
		int start = (p.getPage()-1)*p.getMaxNumber()+1;
		int end = p.getPage()*p.getMaxNumber();
	
		sql+= start +" and "+ end +"order by id";
	   
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnetcion();
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				list.add(user);
			}
			JDBCUtils.close(conn, pre, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteUserById(int id) {	
		String sql = "delete from t_user where id =?";
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JDBCUtils.getConnetcion();
			pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			pre.executeUpdate();
			JDBCUtils.close(null, pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findByName(String username) {
//		System.out.println(username);
		String sql = "select * from t_user";
		if(username!=null){
			sql+=" where name like '%"+username+"%'";
		}
		sql+="order by id";
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnetcion();
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				list.add(user);
			}
			JDBCUtils.close(conn, pre, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateById(User user) {

		String sql = "update t_user set name = ?, password = ?, birthday = ? where id = ?";
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			 conn = JDBCUtils.getConnetcion();
			 pre = conn.prepareStatement(sql);
			 pre.setString(1, user.getUsername());
		     pre.setString(2,user.getPassword());
		     pre.setDate(3, new Date(user.getBirthday().getTime()));
		     pre.setInt(4,user.getId());
		     pre.executeUpdate();
			 JDBCUtils.close(null, pre);
		} catch (SQLException e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
	}

	@Override
	public int countUser() {
		String sql = "select id from t_user";
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JDBCUtils.getConnetcion();
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			System.out.println("统计失败！");
			e.printStackTrace();
		}finally{	
			JDBCUtils.close(conn, pre,rs);
		}
		
		return count;
	}

	
}
