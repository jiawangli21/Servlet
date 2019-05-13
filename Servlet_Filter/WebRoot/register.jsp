<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
    .d1{
       position:absolute;left:500px;top:200px;
    }
   .i1{
         width:250px;
         height:30px;
         margin:5px;
      }
       #d2{
           margin:5px;
           position:absolute;left:100px;
        }
        #d2 input{
           width:60px;
           height:30px;
        }
        .d3{
           width:80px;
           height:30px;
           margin-left:120px;
        }
</style>
</head>
<body>
      <div class="d1">
          <div class="d3">注册页面</div>
         <form action="/Servlet_Filter/register" method="post">
	                             用户: <input class="i1" type="text" name="username"/><br>
	                             密码: <input class="i1" type="text" name="password"/><br>
	                             生日: <input class="i1" type="text" name="birthday"/><br>                   
	              <div id = "d2">
		                   <input type="submit" value="submit"/>
		                   <input type="reset" value="reset"/>
		          </div>
          </form> 
      </div>
</body>
</html>