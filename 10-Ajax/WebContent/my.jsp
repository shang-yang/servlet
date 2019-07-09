<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 声明js代码域 -->
<script>
	function getDate() {
		// 获取元素对象
		var showdiv = document.getElementById("showdiv");
		// 修改元素内容
		showdiv.innerHTML="哈哈，乌拉拉拉拉";
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