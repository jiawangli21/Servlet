 package com.java.servlet1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

public class FindServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		
/*		
	    Cookie[] cook =	request.getCookies();
		if(cook!=null){
			for (Cookie cookie : cook) {
				if("JSESSIONID".equals(cookie.getName())){
					cookie.getValue();
				}
			}
		}*/
		UserService service  = new UserServiceImpl();
		
		List<User> list = service.findByName(username);
		if(request.getSession().getAttribute("list") != null && list != null){
			request.getSession().removeAttribute("list");
			request.getSession().setAttribute("list", list);
		}else{
			request.getSession().setAttribute("list", list);
		}
		response.sendRedirect("/Servlet_Filter/showUser.jsp");
		
	}
}
