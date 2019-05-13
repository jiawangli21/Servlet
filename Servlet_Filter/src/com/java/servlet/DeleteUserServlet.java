package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 UserService service  = new UserServiceImpl();
         String id = request.getParameter("id");
         System.out.println(id);
         service.deleteUserById(Integer.parseInt(id));
         request.getRequestDispatcher("/login/find").forward(request, response);
//       response.sendRedirect("find");
	}
}
