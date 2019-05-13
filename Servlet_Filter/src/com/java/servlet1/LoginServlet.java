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
		//��ȡ��֤��
        String code = request.getParameter("code");
        String url ="/Servlet_Filter/nopassfilter/find";
        boolean bool = false;
        //��֤��У��
        if(request.getSession().getAttribute("validationCode").equals(code)){
           username = request.getParameter("username");
    	   password = request.getParameter("password"); 
    	   if(!"".equals(username) && !"".equals(password)){		   
    		    //��֤�û���-����
	           	bool = service.login(username, password);
    	   }else{
    		   url = "/Servlet_Filter/login.html";
    	   }
        }
        //�����¼״̬
		if(bool){
		 	//����cookie��ֵ
           	Cookie cook = new Cookie("userinfo", "username="+username+"&"+"password="+password+"&"+"autoLogin="+autoLogin);
           	cook.setMaxAge(Tool.countTime(timeout));
           	response.addCookie(cook);
           	//���õ�¼��־
			HttpSession session = request.getSession();
			session.setAttribute("LoginStatus", "1");
			//����session����Чʱ��
			session.setMaxInactiveInterval(60*60);
			//�ض�����ҳ��
			response.sendRedirect(url);
		}else{
			//�ض��򵽵�¼ҳ��
			response.sendRedirect(url);
		}	
	}
}
