<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script>
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    	<li><a href="#">回首页</a></li>
    	<li><a href="#">帮助</a></li>
    	<li><a href="#">关于</a></li>
    </ul>    
</div>  
<div class="loginbody">    
    <span class="systemlogo"></span>
    <br>
    <%
    	// 声明java代码块，进行逻辑提示语的校验
    	Object obj = request.getAttribute("flag");
    	if(obj != null) {
    %>
    <div style="text-align:center;">
    	<span style="font-size:15px;color:darkred;font-weight:bold;">用户名或密码错误</span>
    </div>
    <%
    	}
    %>
    <%
    	// 声明java代码块，进行密码修改的校验
    	Object pwd = session.getAttribute("pwd");
    	if(pwd != null) {
    %>
    <div style="text-align:center;">
    	<span style="font-size:15px;color:darkgreen;font-weight:bold;">密码修改成功</span>
    </div>
    <%
    	};
    	session.removeAttribute("pwd");
    %>
        <%
    	// 声明java代码块，进行密码修改的校验
    	Object reg = session.getAttribute("reg");
    	if(reg != null) {
    %>
    <div style="text-align:center;">
    	<span style="font-size:15px;color:darkgreen;font-weight:bold;">注册成功</span>
    </div>
    <%
    	};
    	session.removeAttribute("reg");
    %>
    <div class="loginbox loginbox1">
    <form action="user" method="post">
    	<input type="hidden" name="oper" value="login">
    <ul>
    	<li><input name="uname" type="text" placeholder="用户名" class="loginuser"/></li>
    	<li><input name="pwd" type="password" placeholder="密码" class="loginpwd"/></li>
    	<li class="yzm">
    		<span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
    	</li>
    	<li><input name="" type="submit" class="loginbtn" value="登录"/><label><a href="user/reg.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    </div>
</div>   
<div class="loginbm">版权所有  2019  <a href="https://www.cnblogs.com/shangyang/">殇央</a>  仅供学习交流，勿用于任何商业用途  交流QQ：2312197311</div>    
</body>
</html>