<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js" charset="UTF-8"></script>
<script type="text/javascript">
// 页面加载完成后执行
// 相当于：window.onload = function() {}    $(document).ready(function() {});
$(function(){
	alert("aaaaaaa");
	$("form").submit(function() {
		
		// 表单选择器，  :input标签type属性值
		if($(":text:eq(0)").val()=="" || $(":text:eq(1)").val()=="" || $(":text:eq(2)").val()=="") {
			alert("请填写完整信息");
			// 阻止默认行为
			return false;
		}		
	});
});
</script>
</head>
<body>
<form action="insert" method="post">
<table border="1" align="center">
	<tr>
		<td colspan="2" style="text-aglin:center;font-size:30px;font-weight:bold;">
			花卉信息
		</td>
	</tr>
	<tr>
		<td><b>花卉名称：</b></td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>花卉价格</td>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<td>花卉原产地</td>
		<td><input type="text" name="production"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="提交"><input type="reset" value="重置">
		</td>
	</tr>
</table>
</form>
</body>
</html>