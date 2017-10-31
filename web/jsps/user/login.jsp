<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.div1{
			margin: 0 auto;
			margin-top: 10%;
			width: 700px;
			height: 500px;
			text-align: center;
			border:2px dotted rgb(242,195,147);
			background-image: url("<c:url value='/images/log.jpg'/>");

		}
		 #h1{
			 letter-spacing: 50px;
			 margin-top: 80px;
			 font-size: 30pt;
			font-family: "Verdana", "Arial", "Helvetica", "sans-serif";
		}
		#img{
			margin-right: 15%;

		}
		input,.span1{
			font-size: 15pt;
		}
		#sub{
			background-color: rgb(242,195,147);
			border-radius: 20%;
			width: 75pt;
			margin-left: 13%;
			color: rgb(240,237,204);
		}

	</style>
  </head>
  
  <body>
  <div class="div1">
	  <h1 id="h1">&nbsp;欢迎登录</h1>
	  <span style="color: red; font-weight: 900">${msg}</span>
	  <form action="${pageContext.request.contextPath}/UserServlet" method="post">
		  <input type="hidden" name="method" value="login">
		  <span class="span1">用户名：</span><input type="text" name="username" value="${fromuser.username}"/><br/><br/>
		  <span class="span1">密　码：</span><input type="password" name="password" value="${fromuser.password}"/><br/><br/>
		  <input id="sub" type="submit" value="点击登录"/><br>
		  <img id="img" src="<c:url value="/images/log1.jpg"/> ">
	  </form>
  </div>

  </body>
</html>
