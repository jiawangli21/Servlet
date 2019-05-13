<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
     .top_1{
         width:99%;
         height:200px;
         background-color:lightblue ;
         position:absolute;
         border-radius:5px;
     }
     .top_2{
        position:absolute;left:200px;top:70px;
        font-size:30px;
     }
       .d3{
       width:150px;
       height:50px;
       position:absolute;right:100px;top:30px;
    }
    .d3_1{
       position:absolute;right:5px;top:10px;
    }
    .d3 img{
       width:40px;
       height:40px;
       border-radius:20px;
    }
     .d1{
        position:absolute; left:500px; top:150px;
     }
     #i1{
        width:250px;
        height:30px;
        font-size:15px;
     }
     #i2{
        width:60px;
        height:37px;
        font-size:15px;
     }
</style>
</head>
<body>
      <div class="top_1">
           <div class="top_2">
                                              用户信息管理页面
           </div>
      </div>
      
      <div class="d3">
           <img alt="头像" src="image/head.png">
           <div class="d3_1">
               <button><a href="/Servlet_Filter/nopassfilter/login">登录</a></button>
               <button><a href="/Servlet_Filter/register.jsp">注册</a></button>
           </div>
     </div>
     <div class ="d1">
	     <form action="/Servlet_Filter/login/findByName" method="post">
	        <input id ="i1" type="text" name="username"/>
	        <input id="i2" type="submit" value="查询"/>
	     </form>
     </div>
</body>
</html>