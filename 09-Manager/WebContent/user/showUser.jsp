<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shangyang.pojo.User,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>	

<script type="text/javascript">
$(document).ready(function(){
	$(".click").click(function(){
		$(".tip").fadeIn(200);
	});
	$(".tiptop a").click(function(){
		$(".tip").fadeOut(200);
	});
	$(".sure").click(function(){
		$(".tip").fadeOut(100);
	});
	$(".cancel").click(function(){
		$(".tip").fadeOut(100);
	});
});
</script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">查看个人信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th>用户ID<i class="sort"><img src="../images/px.gif" /></i></th>
	        <th>用户名</th>
	        <th>密码</th>
	        <th>性别</th>
	        <th>年龄</th>
	         <th>出生年月</th>
        </tr>
        </thead>
        <tbody>
			<%
	        	List<User> lu = (ArrayList<User>)request.getAttribute("lu");
	        	for(User u:lu) {
	        %>
	        <tr>
	        <td><%=u.getUid() %></td>
	        <td><%=u.getUname() %></td>
	        <td><%=u.getPwd() %></td>
	        <td><%=u.getSex().equals("1") ? "男" : "女" %></td>
	        <td><%=u.getAge() %></td>
	        <td><%=u.getBirth() %></td>
	        </tr>
	        <%
	        	}
	        %>  
        </tbody>
    </table> 
    </div>

</body>
</html>