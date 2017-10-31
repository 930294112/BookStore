<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style >
		div{

			margin: auto;
			text-align: center;
			width: 600px;
			height: 700px;
			border: 1px solid black;
		}
		#form{
			font-size: 24px;
			margin-top: 25%;
		}
		.i1{
			font-size: 18px;
		}
		#i2{
			width: 90px;
			height: 45px;
			border-radius: 20%;

		}

	</style>
  </head>
  
  <body>

  <div>
	  <h1>管理员登录页面</h1>
	  <hr/>
	  <p style="font-weight: 900; color: red">${msg}</p>
	  <form id="form" action="${pageContext.request.contextPath}/AdminServlet">
		  <input type="hidden" name="method" value="login">
		  管理员账户：<input class="i1" type="text" name="aname" value=""/><br/><br>
		  密　　　码：<input  class="i1" type="password" name="apwd"/><br/><br>
		  <input id="i2" type="submit" value="进入后台"/>
	  </form>
  </div>

  </body>
</html>
