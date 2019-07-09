<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shangyang.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	
	// 退出功能
	$("#out").click(function() {
		var flag = window.confirm("你真的要退出么？");
		if(flag) {
			window.top.location.href="../user?oper=out";
		}
	})
})

</script>
</head>
<body style="background:url(../images/topbg.gif) repeat-x;">
    <div class="topleft">
    	<a href="main.jsp" target="_parent"><img src="../images/logo.png" title="系统首页" /></a>
    </div>        
    <div class="topright">    
	    <ul>
		    <li><span><img src="../images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    <li><a href="javascript:void(0)" id="out">退出</a></li>
	    </ul>    
	    <div class="user">
	    	<span>${sessionScope.user.uname }</span>
	    	<span>当前在线人数为：${applicationScope.count }</span>
	    </div>       
    </div>
</body>
</html>