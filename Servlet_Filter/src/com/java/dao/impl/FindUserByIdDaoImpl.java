package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.dao.FindUserByIdDao;
import com.java.entity.User;
import com.java.tool.JDBCUtils;

public class FindUserByIdDaoImpl implements FindUserByIdDao{

	@Override
	public User findById(int id) {
	    String sql ="select * from t_user where id = ?";
	    Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JDBCUtils.getConnetcion();
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
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
}
