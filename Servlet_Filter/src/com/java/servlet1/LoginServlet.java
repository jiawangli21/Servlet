package com.java.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;
import com.java.tool.Tool;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String username = null;
		String password = null;
		String timeout = request.getParameter("timeout");
		String autoLogin = request.getParameter("check");
		//获取验证码
        String code = request.getParameter("code");
        String url ="/Servlet_Filter/nopassfilter/find";
        boolean bool = false;
        //验证码校验
        if(request.getSession().getAttribute("validationCode").equals(code)){
           username = request.getParameter("username");
    	   password = request.getParameter("password"); 
    	   if(!"".equals(username) && !"".equals(password)){		   
    		    //验证用户名-密码
	           	bool = service.login(username, password);
    	   }else{
    		   url = "/Servlet_Filter/login.html";
    	   }
        }
        //保存登录状态
		if(bool){
		 	//保存cookie的值
           	Cookie cook = new Cookie("userinfo", "username="+username+"&"+"password="+password+"&"+"autoLogin="+autoLogin);
           	cook.setMaxAge(Tool.countTime(timeout));
           	response.addCookie(cook);
           	//设置登录标志
			HttpSession session = request.getSession();
			session.setAttribute("LoginStatus", "1");
			//设置session的有效时间
			session.setMaxInactiveInterval(60*60);
			//重定向到主页面
			response.sendRedirect(url);
		}else{
			//重定向到登录页面
			response.sendRedirect(url);
		}	
	}
}
