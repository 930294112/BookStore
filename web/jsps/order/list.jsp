<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    <script src="/jquery-3.2.1.js"></script>
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
		border: solid 2px gray;
		width: 75px;
		height: 75px;
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
</style>
  </head>
  
  <body>
<h1 style="font-size: 20px">我的订单</h1>
<h1 style="font-size: 35px;text-align: center">${msg}</h1>
<table border="1" width="100%" cellspacing="0" background="rgb(220,228,193)">
	<c:forEach var="od" items="${order}">
		<tr style="background-color: rgb(220,228,193);border-color: rgb(220,228,193)">
			<td colspan="6">
				订单编号：${od.oid}　成交时间：${od.ordertime}　金额：<font style="color: rgb(85,26,139)"><b>${od.total}</b></font>　

				<a id="pay" href="${pageContext.request.contextPath}/OrderServlet?method=load&oid=${od.oid}">
					<c:if test="${od.state==1}">
						<input type="button" style="width: 90px; text-align: center;background-color: rgb(220,228,193)" value="点击付款" >
					</c:if>
				</a>
					<c:if test="${od.state==2}">
						<input type="button" style="width: 90px; text-align: center ;background-color: rgb(220,228,193)" value="待发货" >
					</c:if>
					<c:if test="${od.state==3}">
						<a href="${pageContext.request.contextPath}/OrderServlet?method=confirm&oid=${od.oid}">
							<input type="button" style="width: 90px; text-align: center ;background-color: rgb(220,228,193)" value="点击收货">
						</a>

					</c:if>
					<c:if test="${od.state==4}">
						<input type="button" style="width: 90px; text-align: center ;background-color: rgb(220,228,193)" value="订单完成" >
					</c:if>


			</td>
		</tr>
		<c:forEach var="orderItem" items="${od.orderItemList}">
			<tr bordercolor="gray" align="center">
				<td width="15%">
					<div><img src="<c:url value='${orderItem.book.image}'/>" height="75"/></div>y
				</td>
				<td>书名：${orderItem.book.bname}</td>
				<td>单价：${orderItem.book.price}元</td>
				<td>作者：${orderItem.book.author}</td>
				<td>数量：${orderItem.count}}</td>
				<td>小计：${orderItem.subtotal}元</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
  </body>
</html>
