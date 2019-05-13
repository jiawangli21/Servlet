package com.java.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginNoPassWordFilter implements Filter{
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException { 
	    HttpServletRequest req =(HttpServletRequest)request;
	    HttpServletResponse res = (HttpServletResponse)response;
	    String userinfo = null;
	    Cookie[] cook = req.getCookies();
	    String[] s = null;
	    String autoLogin = null;
	    Map<String,String> map = getAutoLogin(cook);
	    autoLogin = map.get("autoLogin");
	    Object loginstatus = req.getSession().getAttribute("LoginStatus");
 	    if("1".equals(autoLogin)){
	    	//�Զ���¼--��ת����ҳ��
	    	if(!"1".equals(loginstatus)){
	    		req.getSession().setAttribute("LoginStatus",1);
	    	}
	    	res.sendRedirect("/Servlet_Filter/login/find"); 
		}else{
			//�Ѿ���½��--ֱ����ת����ҳ��
			if((userinfo!=null || loginstatus!=null)){
		    	if(!"1".equals(loginstatus)){
		    		req.getSession().setAttribute("LoginStatus",1);
		    	}
		    	res.sendRedirect("/Servlet_Filter/login/find");     
		    }else{
		    	//ת���¼ҳ��
		    	res.sendRedirect("/Servlet_Filter/login.html");
		    }
		}    
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	/**
	 * �����������cookie���д���
	 * @param cookie
	 * @return
	 */
	public Map<String,String> getAutoLogin(Cookie[] cookie){
		Map<String, String> map = new HashMap<String, String>();
		if (cookie!=null) {
			String userinfo = null;
			for (Cookie cook : cookie) {
				if("userinfo".equals(cook)){
					userinfo = cook.getValue();
				}
			}
			if(userinfo!=null){
				String[] info = userinfo.split("&");
				for (int i = 0; i < info.length; i++) {
					String[]  str = info[i].split("=");	
					map.put(str[0], str[1]);
				}
			}
		}
		return map;
	}
}
