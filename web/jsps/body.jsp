<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
      <style >
          img{
              /*设置圆形*/
              border-radius: 40%;
              /*倾斜角*/
            -moz-transform: rotate(25deg);
              width: 150px;
              height: 150px;
          }

          .img1{
             margin-top:4%;
              margin-left:9%;
          }
          .img2{
              margin-top: 6%;
              margin-left: 4%;
          }
          .img3{
              margin-left: 4%;
              margin-top: 4%;
          }
          .img4{
              margin-left: 4%;
              margin-top: 6%;
          }
         div #h1{
              color: rgb(85, 26, 139);
              text-align: center;
              letter-spacing: 18px;
              font-size: 75px;
              font-family: 'DejaVu Serif', Georgia, "Times New Roman", Times, serif;

            }

      </style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
      <img class="img1" src=" <c:url value='/images/book1.jpg'/>">
      <img class="img2" src=" <c:url value='/images/hua.jpg'/>">
      <img class="img3" src=" <c:url value='/images/book2.jpg'/>">
      <img class="img4" src=" <c:url value='/images/hua1.jpg'/>">
      <h1 id="h1">welcome~</h1>
      <img class="img1" src=" <c:url value='/images/hua2.jpg'/>">
      <img class="img2" src=" <c:url value='/images/book3.jpg'/>">
      <img class="img3" src=" <c:url value='/images/hua3.jpg'/>">
      <img class="img4" src=" <c:url value='/images/book4.jpeg'/>">

  </div>

  </body>
</html>
