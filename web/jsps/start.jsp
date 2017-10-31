<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/9/29
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/jquery-3.2.1.js"></script>
    <style>
        div{
           margin-left: 20%;
            font-size: 20px;
        }
        textarea{
            border: 2px dotted rgb(220,228,193);
        }
        input{
            width: 60px;
            height: 35px;
            border-radius: 20%;
            margin-left: 37%;
        }
    </style>
</head>
<body>
<div>
    订单已完成~买家将收到您的确认信息!<br><br>
    <form action="${pageContext.request.contextPath}/OrderServlet">
        <input type="hidden" name="method" value="addContext">
        请输入评价:<br>
        <textarea cols="55" rows="25" name="context"></textarea><br>
        点亮小星星哟~:
        <span id="0">☆</span>
        <span id="1">☆</span>
        <span id="2">☆</span>
        <span id="3">☆</span>
        <span id="4">☆</span><br>
        <%--<a href="<c:url value="/jsps/body.jsp"/> ">--%>
        <%--</a>--%>
        <input  id="i1" type="submit" value="提交">
    </form>

</div>
<script>
    document.getElementById("i1").onclick=function () {
        alert(" 买家将收到您的留言,么么哒~")
    }
    var spans= document.getElementsByTagName("span");
    var flag = 5;
    var Expand=function () {
        //
    };
    onload=function () {
        //循环载入鼠标移入事件
        for (var i=0;i<spans.length;i++){
            spans[i].onmouseover=function () {
                var id = parseInt(this.id);
                for (var i=0;i<id;i++){
                    spans[i].innerHTML="★";
                }
                for (var j=id+1;j<5;j++){
                    spans[j].innerHTML="☆"
                }
            }
        }
        //循环载入鼠标移入事件
        for(var i=0;i<spans.length;i++){
            spans[i].onclick=function(){
                var id=parseInt(this.id);
                flag=id;
                for(var i=0;i<=id;i++){
                    spans[i].innerHTML="★";
                }
                Expand();//这里是鼠标点击星星的扩展，例如出现分值之类的，总之要扩展什么随你的大小便啦~
            };
        }

        //载入鼠标离开div事件
        document.getElementById("div").onmouseout=function(){
            //如果tag是3，则循环给把0 1 2 3几个星星整黄
            if(flag>=0 && flag<=4){
                for(var i=0;i<=flag;i++){
                    spans[i].innerHTML="★";
                }
                for(var j=flag+1;j<5;j++){
                    spans[j].innerHTML="☆";
                }
            }
            //如果tag没有值或者是初值5，则把所有的星星还原成空星星
            else{
                for(var i=0;i<spans.length;i++){
                    spans[i].innerHTML="☆";
                }
            }
        };
    }
</script>
</body>
</html>
