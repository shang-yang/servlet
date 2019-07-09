<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	1、在当前页面内显示查询结果，考虑使用ajax
	2、创建ajax函数
	3、调用ajax函数发送请求到UserServlet
	4、调用业务层获取对应的数据
 -->
 <script type="text/javascript" src="ajaxUtil.js"></script>
<script type="text/javascript">
	// 获取数据
	function getData() {
		// 获取用户请求信息
		var name = document.getElementById("uname").value;
		// 创建ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxm12.XMLHTTP");
		}
		// 复写onreadystatechange
		ajax.onreadystatechange=function() {
			// 判断ajax状态码
			if(ajax.readyState == 4) {
				if(ajax.status == 200) {
					// 获取响应数据
					var result = ajax.responseXML;
					//alert(result);
					eval("var u =" + result);
					//alert(result);
					// 处理响应数据
				}
			}
		}
		// 发送请求
		ajax.open("get","user?name=" + name);
		ajax.send(null);
	}

	
	function getData2() {
		var name = document.getElementById("uname").value;
		var data = "name=" + name;
		
		myAjax("get","user",data,function(ajax) {
			// 获取响应数据
			var result = ajax.responseText;
			//alert(result);
			eval("var u =" + result);
			alert(result);
		})
	}
	
</script>
</head>
<body>
	<h3>欢迎访问XML数据格式学习</h3>
	<hr>
	英雄名称：<input type="text" name="uname" value="" id="uname" />
		<input type="button" value="搜索" onclick="getData2()">
	<hr> 
	<table border="1px" id="ta">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>位置</td>
			<td>描述</td>
		</tr>
	</table>
</body>
</html>