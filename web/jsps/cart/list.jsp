<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lanou.bookstore.cart.structure.Cart" %>
<%@ page import="com.lanou.bookstore.cart.structure.CartItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>
    
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
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#img1{
		width: 40px;
		height: 40px;
		border-radius: 40%;
	}
	#img2{
		width: 500px;
		height: 450px;
		border-radius: 30px;
		margin-left: 30%;
		border: 2px dotted rgb(220,228,193);
	}
	#h1{
		margin-left: 20%;
	}
</style>
  </head>
  
  <body>
<h1 style="font-size: 20px">购物车<img id="img1" src="<c:url value="/images/cart.png"/> " alt=""></h1>
<c:choose>
	<c:when test="${user==null}">
		<h1 id="h1" style="font-size: 35px">登录才能买买买!</h1>
		<img id="img2" src="<c:url value="/images/maimiamia.jpg"/>"/>
	</c:when>
<c:otherwise>
<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="${pageContext.request.contextPath}/CartServlet?method=clear">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
		<%--车在session中,通过车得到所有的cartItemMap--%>
	<c:forEach var="cartItemMap" items="${sessionScope.cart.cartItemMap}">
		<tr>
			<td><div><img src="<c:url value='${cartItemMap.value.book.image}'/>"/></div></td>
			<td>${cartItemMap.value.book.bname}</td>
			<td>${cartItemMap.value.book.author}</td>
			<td>${cartItemMap.value.book.price}</td>
			<td>${cartItemMap.value.count}</td>
			<td>${(cartItemMap.value.count)*(cartItemMap.value.book.price)}</td>
			<td><a href="${pageContext.request.contextPath}/CartServlet?method=delete&bid=${cartItemMap.key}">删除</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<input type="hidden" <c:set var="sum" value="0"/>
			<c:forEach var="v" items="${sessionScope.cart.cartItemMap}">
				${sum=sum+(v.value.count)*(v.value.book.price)}
			</c:forEach>>
			合计:${sum}元

		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="${pageContext.request.contextPath}/OrderServlet?method=add&sum=${sum}"></a>
		</td>
	</tr>
</table>
  </body>
	</c:otherwise>
</c:choose>

</html>
