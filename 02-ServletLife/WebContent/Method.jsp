<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="request" method="get">
		用户名：<input type="text" name="uname" value="" /><br/>
		密码：<input type="text" name="pwd" value="" /><br/>
		爱好：
			<input type="checkbox" name="fav" value="1">1
			<input type="checkbox" name="fav" value="2">2
			<input type="checkbox" name="fav" value="3">3
			<br>
		<input type="submit" value="登录" />
	</form>
</body>
</html>