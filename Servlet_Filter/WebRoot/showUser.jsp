<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="jsp/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>展示所有的用户信息页面</title>
<style type="text/css">
    
    a{
      text-decoration: none;
    }
    .d2{
       border:solid 1px darkgrey;
       width:800px;
       height:475px;
       position:absolute;left:263px;top:220px;
       border-radius:5px;
     }
     .d2_1{
         height:30px;
         width:100%;
         position:absolute;bottom:5px;     
     }
     .d2_1_1{
         height:30px;
         width:200px;
         position:absolute;left:280px;     
     }
     .d2_1_1 a{
        margin-left:5px;
     }
    tr{
      height:35px;
    }
    td{
       width:110px;
       aligin:;
       padding-left:40px;
    }
    td a{
       margin-left:8px;
       color:#008000;
    }
    td a:HOVER{
       font-size:15px;
       color:red;
    }
    .bottom{
        width:98%;
        height:50px;
        position:absolute;top:700px;
    }
    .top{
        width:99%;
        height:200px;
        border-radius:5px;
     }
     .left{
        border:solid 1px darkgrey;
        width:240px;
        height:475px;
        border-radius:5px;
        position:absolute;left:10px;top:220px;
     }
</style>
</head>
 <body>
      <div class="top">
           <jsp:include page="jsp/top.jsp"></jsp:include>
      </div>
      <div class="left" >
        <jsp:include page="jsp/left.jsp"></jsp:include>
      </div>
     
	 <div class="d2">
	     <table  cellpadding="3" cellspacing="2">
			  <tr>
			    <th>编号</th>
				<th>用户名称</th>
				<th>密码</th>
				<th>生日</th>
				<th>操作</th>
			  </tr>
	    
			<c:forEach var="user" items="${sessionScope.list}">
				<tr>
				    <td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.birthday}</td>
					<td>
					   <a href="/Servlet_Filter/login/update?id=${user.id}&redirect=1">修改</a>
					   <a href="/Servlet_Filter/login/delete?id=${user.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
	     </table>
	     <div class="d2_1">
	          <div class="d2_1_1">
	              <a href="/Servlet_Filter/login/find?page=1">首页</a>
	              <a href="/Servlet_Filter/login/find?page=${sessionScope.page-1}">上一页</a>
	              <a href="/Servlet_Filter/login/find?page=${sessionScope.page+1}">下一页</a>
	              <a href="/Servlet_Filter/login/find?page=${maxPage}">尾页</a>
	          </div>
	     </div>
	 </div>
	 <div class="bottom">
	     <jsp:include page="jsp/bottom.jsp"></jsp:include>
	 </div>
</body>
</html>