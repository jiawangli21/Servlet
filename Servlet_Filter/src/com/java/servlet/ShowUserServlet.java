package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.Page;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

public class ShowUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service  = new UserServiceImpl();
		Page p = new Page();
		String page = request.getParameter("page");
		System.out.println("page="+page);
	
		//统计用户数量
		int count = service.countUser();
		System.out.println("count="+count);
		//计算最大页数
		int maxPage = p.getMaxPage(count);
		//判断page是否合理
		p.setMaxPage(maxPage);
	    if(page!=null){
			p.setPage(Integer.parseInt(page));
			p.setPage(p.CountPage(p));
			//保存数据到session中
		}
		System.out.println(p);
		request.getSession().setAttribute("page",p.getPage());
		request.getSession().setAttribute("maxPage",p.getMaxPage());
		
		List<User> list = null;
	    list = service.findAllUser(p);
		request.getSession().setAttribute("list",list);
		response.sendRedirect("/Servlet_Filter/showUser.jsp");		
	}
}
