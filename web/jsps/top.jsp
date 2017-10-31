<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
	.a1{
		margin-left: 70%;
	}
   span{
       color: rgb(85, 26, 139);
   }





</style>
  </head>
  <body>
  <div style="font-size: 12pt;">
	  <h1 style="text-align: center">橙煦圆的店</h1>

    <br>
		<span>您好：</span>
	<c:choose>
		<c:when test="${not empty user.username}">
			 ${user.username}
		</c:when>
		<c:otherwise>
			<span>请登录</span>
		</c:otherwise>
	</c:choose>
	<br>
	<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a> |&nbsp;
	<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册</a> |&nbsp;
	<a href="${pageContext.request.contextPath}/UserServlet?method=quit">退出</a>

	<a class="a1" href="<c:url value='/jsps/cart/list.jsp'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<a  href="${pageContext.request.contextPath}/OrderServlet?method=myOrders" target="body">我的订单</a>&nbsp;&nbsp;



</div>
  </body>
</html>
