<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	
	{
		// 获取响应内容
		var result = ajax.responseText;
		// 获取元素对象
		var showdiv = document.getElementById("showdiv");
		// 修改元素内容
		showdiv.innerHTML=result;
		
		
		
		// 获取元素对象
		var showdiv = document.getElementById("showdiv");
		// 修改元素内容
		showdiv.innerHTML="请求资源不存在";
		
		
		// 获取元素对象
		var showdiv = document.getElementById("showdiv");
		// 修改元素内容
		showdiv.innerHTML="服务器繁忙";
	}
</script>
<style>
	#showdiv {
		border:solid 1px;
		width:200px;
		height:100px;
	}
</style>
</head>
<body>
	<h3>欢迎登录</h3>
	<hr>
	<input type="button" value="测试" onclick="getDate()" />
	<div id="showdiv">
	</div>
</body>
</html>