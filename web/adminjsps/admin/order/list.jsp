<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
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
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<c:forEach var="order" items="${orders}">
			<td colspan="6">
				订单：${order.oid}　成交时间：${order.ordertime}　金额：<font color="red"><b>${order.total}</b></font>
				<c:if test="${order.state==1}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="未付款" >
				</c:if>
				<c:if test="${order.state==2}">

					<a href="${pageContext.request.contextPath}/AdminOrderServlet?method=send&oid=${order.oid}">
						<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="点击发货" >
					</a>

				</c:if>
				<c:if test="${order.state==3}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="等待买家收货" >
				</c:if>
				<c:if test="${order.state==4}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="订单完成" >
				</c:if>
			</td>

			<c:forEach var="oderItem" items="${order.orderItemList}">
	            <tr bordercolor="rgb(78,78,78)" align="center">
	            	<td width="15%">
	            		<div><img src="<c:url value='${oderItem.book.image}'/>" height="75"/></div>
	            	</td>
	            	<td>书名：${oderItem.book.bname}</td>
	            	<td>单价：${oderItem.book.price}元</td>
	            	<td>作者：${oderItem.book.author}</td>
	            	<td>数量：${oderItem.count}</td>
	            	<td>小计：${oderItem.subtotal}元</td>
	            </tr>
	        </c:forEach>
		</c:forEach>
	</tr>

</table>
  </body>
</html>
