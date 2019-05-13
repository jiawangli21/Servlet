package com.java.servlet1;

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

public class UpdateServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String id = request.getParameter("id");
		String redirect = request.getParameter("redirect");
		
		System.out.println("redirect="+redirect);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		if(!"1".equals(redirect)){
			int newId = Integer.parseInt(id);
			
			Date date = null;
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				date = format.parse(birthday);
			} catch (ParseException e) {
				response.sendRedirect("/Servlet_Filter/update.js");
				e.printStackTrace();
			}
			User user = new User(newId, username, password,date);
			service.updateById(user);
			response.sendRedirect("/Servlet_Filter/login/find");
		}else{
			request.getSession().setAttribute("id", id);
			User user = service.findById(Integer.parseInt(id));
			request.getSession().setAttribute("name", user.getUsername());
			request.getSession().setAttribute("pass", user.getPassword());
			request.getSession().setAttribute("birth", user.getBirthday());
			response.sendRedirect("/Servlet_Filter/update.jsp");
		}
	}
}
