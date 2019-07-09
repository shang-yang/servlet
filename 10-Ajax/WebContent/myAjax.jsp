<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	Ajax学习：
		1、ajax的概念
			局部刷新技术，不是一门新技术，是多种技术的组合，是浏览器端的技术。
		2、ajax的作用
			实现在当前结果页中显示其他请求的响应内容
		3、ajax的使用
			ajax的基本流程
				// 创建ajax引擎对象
				// 复写 onreadyStatechange函数
					// 判断ajax状态码
						// 判断响应状态码
							// 获取响应内容（响应内容的格式）
								// 普通字符串 responseText
								// json		responseText
									其实就是将数据按照json的格式拼接好的字符串，方便使用eval方法
									将接受的字符串数据直接转换为js的对象
									
									json格式：
									var 对象名 = {
										属性名 ： 属性值，
										属性名 ： 属性值，
										...
									}
								// XML数据	responseXML. 返回document对象
										通过document对象将数据从xml中获取出来
							// 处理响应内容（js操作文档结构）
				// 发送请求
					// get请求
						get的请求实体拼接在URL后面， ? 隔开，键值对
						ajax.open("get" , "url");
						ajax.send(null);
					// post请求
						有单独的请求实体
						ajax.open("post","ajax");
						ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
						ajax.send("name=李四&pwd=qwe");
			ajax的状态码
				ajax状态码
					readyState: 0、1、2、3、4
						4: 表示响应内容被重新接收
				响应状态码
					status
						200: 表示一切OK
						404: 资源未找到
						500: 内部服务器错误
			ajax的异步和同步
				ajax.open(method, url, async)
				async:设置同步代码执行还是异步代码执行
					true  代表异步，默认是异步
					false 代表同步
 -->
<!-- 声明js代码域 -->
<script>
	function getDate() {
		// 创建Ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxml2.XMLHTTP")
		}
		// 复写onreadystatement函数
		ajax.onreadystatechange=function() {
			// 判断Ajax状态码
			if(ajax.readyState == 4) {
				// 判断响应状态码
				if(ajax.status == 200) {
					// 获取响应内容
					var result = ajax.responseText;
					// 获取元素对象
					var showdiv = document.getElementById("showdiv");
					// 修改元素内容
					showdiv.innerHTML=result;
				} else if (ajax.status == 404) {
					// 获取元素对象
					var showdiv = document.getElementById("showdiv");
					// 修改元素内容
					showdiv.innerHTML="请求资源不存在";
				} else if (ajax.status == 500) {
					// 获取元素对象
					var showdiv = document.getElementById("showdiv");
					// 修改元素内容
					showdiv.innerHTML="服务器繁忙";
				}
			} else {
				// 获取元素对象
				var showdiv = document.getElementById("showdiv");
				// 修改元素内容
				showdiv.innerHTML="请等待~~~~";
			}
		}
		// 发送请求
		ajax.open("get", "ajax",true);
		ajax.send(null);
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