package com.java.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class JDBCUtils {

	private static Properties p= new Properties();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static{
        	try {
				InputStream is = JDBCUtils.class.getResourceAsStream("/jdbc.properties");
				p.load(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static Connection getConnetcion(){
		Connection conn = null;
		if(tl.get()==null){
			try {
/*				Context initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
				conn = ds.getConnection();*/
			try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));

//		        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","root");
			} catch (Exception e) {
				e.printStackTrace();
			}
			tl.set(conn);
		}
		return tl.get();
	}
	
	public static void  close(Connection conn,PreparedStatement pre){
		if(conn!=null){
			try {
				conn.close();
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	public static void  close(Connection conn,PreparedStatement pre,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	
}
