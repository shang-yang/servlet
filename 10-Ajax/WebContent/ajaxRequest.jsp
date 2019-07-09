<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	Ajax请求学习
		


 -->
<!-- 声明js代码域 -->
<script>
	function ajaxReq() {
		// 获取用户请求数据
		var uname=document.getElementById("uname").value;
		var date = "name=" + uname;
		// 创建ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxm12.XMLHTTP");
		}
		// 复写onreadystatechange函数
		ajax.oneradystatechange=function () {
			// 判断ajax状态码
			if(ajax.readyState == 4) {
				//判断响应状态码
				if(ajax.status==200) {
					// 获取响应对象
					var result = ajax.responseTest;
					// 处理响应内容
					alert(result);
				}
			}
		}			
		// 发送请求
			// get方式: 请求实体拼接在URL后面name=张三&pwd=123
			//	ajax.open("get","ajax?" + date);
			//	ajax.send(null);
			// post方式: 请求实体需要单独的发送
				ajax.open("post","ajax");
				ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				ajax.send("name=李四&pwd=qwe");
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
	<input type="text" name="uname" id="uname" value="" />
	<input type="button" value="测试" onclick="ajaxReq()" />
	<div id="showdiv">
	</div>
</body>
</html>