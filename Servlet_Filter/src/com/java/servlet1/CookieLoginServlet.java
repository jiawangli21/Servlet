package com.java.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

public class CookieLoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		response.setCharacterEncoding("GBK");
    	if(!(Boolean) request.getSession().getAttribute("LoginStatus")){
    		response.sendRedirect("find");
    	}else{
    		String name = null;
    		String pass = null;
    		//获取客户端的cookie
            Cookie[] cook = request.getCookies();
            if(cook != null){
            	for (Cookie cookie : cook) {
					if("username".equals(cookie.getName())){
						name = cookie.getValue();
					}
					if("password".equals(cookie.getName())){
						pass = cookie.getValue();
					}
				}
            }
            if(name != null && pass != null){
            	PrintWriter out = response.getWriter();
        		out.print("<html>");
		    		out.print("<body>");
		    		out.print("<div style='position:absolute;left:500px;top:200px;'>");
		    		    out.print("登录页面！<br/>");
			    		out.print(" 用户: <input style='width:250px;height:30px; margin:5px;' type='text' name='username' value='"+name+"'/><br>");
			    		out.print(" 密码: <input style='width:250px;height:30px; margin:5px;' type='password' name='password' value='"+pass+"'/><br>");
			    		out.print("<input style='width:100px;height:30px; margin:5px;' type='text' name='code'/>");
			    		out.print(" <a href='cookieLogin'><img src='/Servlet_Filter/code'/></a><br/>");
			    		out.print("<div style='position:absolute;left:100px;margin:5px;'>");
			    		   out.print("<input style='width:60px;height:30px;' type='submit' value='submit'/>");
			    		   out.print("<input style='width:60px;height:30px;' type='reset' value='reset'/>");
			    		out.print("</div>");
		    		out.print("</div>");
		    		out.print("<body>");
		    		out.print("<body>");
        		out.print("</html>");
            }else{
            	response.sendRedirect("login.html");
            }
            
        }
       
		 
	}}
