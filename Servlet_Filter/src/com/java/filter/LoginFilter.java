package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 
	    HttpServletRequest req =(HttpServletRequest)request;
	    HttpServletResponse res = (HttpServletResponse)response;
	    Object LoginStatus = 0;
	    try {
	    	LoginStatus = req.getSession().getAttribute("LoginStatus"); 
		} catch (Exception e) {
			res.sendRedirect("/Servlet_Filter/login.html");
		}
	    System.out.println("LoginFilter--LoginStatus=" +LoginStatus);
		if("1".equals(LoginStatus)){
			System.out.println("LoginFilter--µÇÂ¼ÁË£¡");
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("/Servlet_Filter/login.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
  
}
