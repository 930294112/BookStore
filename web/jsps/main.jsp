<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>main</title>
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

		*{
			font-size:10pt;
		}
		body{
			text-align:center;

		}
		.table{
			width:1100px;
			height:100%;
			border:1px dotted rgb(220,228,193);/*固定边框,1像素*/
		    border-collapse: collapse;/*单线的列表边框*/
			/*加背景图片*/
			background-image: url("<c:url value='/images/top.jpeg'/>");
			
		}
		.table td{
			border:1px solid rgb(220,228,193);/*固定边框,1像素*/
		}
		iframe {
			width: 100%;
			height: 100%;
		}

	</style>

  </head>

  <body>
  <a href="<c:url value="/adminjsps/login.jsp"/>"><span style="text-decoration: none">Hi~</span></a>
  <br>
  <div>
	  <table class="table" align="center">
          <tr style="height:120px;">
			  <td colspan="2" align="center">
				  <%--iframe 分为上左中三部分--%>
				  <iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
			  </td>
		  </tr>
		  <tr>
			  <td width="120" style="padding:5px;" align="center" valign="top">
				  <iframe frameborder="0" width="120" src="${pageContext.request.contextPath}/CategoryServlet?method=findAll" >
                  </iframe>
			  </td>
			  <td>
				  <iframe frameborder="0" src="<c:url value='/jsps/body.jsp'/>" name="body"></iframe>
			  </td>
		  </tr>
	  </table>
  </div>

  </body>
</html>
