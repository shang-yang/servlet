<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		// 校验密码修改
		$("#fm").submit(function() {
			if($("#newPwd").val()=="") {
				alert("新密码不能为空！");
				return false;
			} else if ($("#cfPwd").val()=="") {
				alert("确认密码不能为空！");
				return false;
			} else if ($("#newPwd").val() != $("#cfPwd").val()) {
				alert("两次密码不一致");
				return false;
			} else {
				return true;
			}
		})
	})

</script>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">个人信息</a></li>
		    <li><a href="#">修改密码</a></li>
	    </ul>
    </div>
    <div class="formbody">
	    <div class="formtitle"><span>修改密码信息</span></div>
	    <form action="../user" method="post" id="fm" target="_top">
	    	<input type="hidden" type="text" name="oper" value="pwd" />
		    <ul class="forminfo">
			    <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /><i></i></li>
			    <li><label>确认密码</label><input name="" id="cfPwd" type="text" class="dfinput" /><i></i></li>
			    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
		    </ul>
	    </form>
    </div>
</body>
</html>