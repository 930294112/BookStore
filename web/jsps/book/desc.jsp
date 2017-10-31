<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书详细</title>
    
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
	body {
		font-size: 10pt;
	}
	div {
		margin:40px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;

	}
	li {
		margin: 10px;
	}
	#a1 {
		background: url(<c:url value='/images/mai.png'/>) no-repeat;
		display: inline-block;
        margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#a1:HOVER {
		background: url(<c:url value='/images/maihou.png'/>) no-repeat;
		display: inline-block;
        margin-left: 30px;
		height: 36px;
		width: 146px;
	}




</style>
  </head>
  <body>
  <div>
    <img src="<c:url value='${load.image}'/>" border="0"/>
  </div>
  <ul>
    <li>书名：${load.bname}</li>
    <li>作者：${load.author}</li>
    <li>单价：${load.price}元</li>
  </ul>
  <form id="form" action="<c:url value='/CartServlet'/>" method="post">
      <input type="hidden" name="method" value="add">
      <input type="hidden" name="method" value="collect">
      <input type="hidden" name="bid" value="${load.bid}">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      数量: <input type="text" size="3" name="count" value="1"/>
  </form>
  <a id="a1" href="javascript:document.getElementById('form').submit();"></a>

  </body>
</html>
