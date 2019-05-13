package com.java.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

public class UserRegisterSerlvet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  UserService  service = new UserServiceImpl();	
      request.setCharacterEncoding("utf-8");		
	  String username =  request.getParameter("username");
	  String password = request.getParameter("password");
	  String birthday = request.getParameter("birthday");
	  SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
	  Date birthdayDate = null ;
	  try {
	      birthdayDate = format.parse(birthday);
	  } catch (ParseException e) {
		   e.printStackTrace();
	  }
	  User user = new User(1, username, password, birthdayDate);	
	  service.register(user);
	  System.out.println("×¢²á³É¹¦£¡");
	  request.getRequestDispatcher("/login/find").forward(request, response);
//	  response.sendRedirect("find");
    }
}
