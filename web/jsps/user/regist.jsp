<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
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
		  .span2{
			  color: coral;
		  }
		  div{
			  /*div水平居中*/
			  margin: 0 auto;
			  margin-top: 10%;
			  width: 700px;
			  height: 500px;
			  text-align: center;
			  border:2px dotted lightpink;
			  background-image: url("<c:url value='/images/reg.jpg'/>");
		  }
		 div #h1{
			  font-size: 40px;
			  letter-spacing: 9pt;
			 font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
		  }
		  div .span1,input{
			  font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
			  font-size: 20px;
		  }
			#input1{
				border-radius: 10%;
				background-color:lavenderblush ;
				margin-left: -170px;
			}

	  </style>

  </head>
  <body>
  <div>
	  <br> <br><h1 id="h1">欢迎注册</h1>
		  <%--显示错误信息--%>
		  <p style="color: coral; font-weight: 900">${msg}</p>
		  <form action="${pageContext.request.contextPath}/UserServlet" method="post">
			  <input type="hidden" name="method" value="regist"/>
			  <span class="span1">用户名：</span><input type="text" name="username" value="${username}"/><br>
			         <span class="span2">${unameError}</span><br>
			  <span class="span1">密　码：</span><input type="password" name="password" value="${password}"/><br>
			         <span class="span2">${pwdError}</span><br/>
			  <span class="span1">邮　箱：</span><input type="text" name="email" value="${email}"/><br>
			        <span class="span2">${emailError}</span><br/><br>
			  <input id="input1" type="submit" value="点击注册"/>
		  </form>

  </div>

  </body>
</html>
