<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL学习</title>
<%--
	JSTL学习：
		作用：
			提高在jsp中的逻辑代码的编写效率，使用标签。
		使用：
			JSTL的核心标签库
			JSTL的格式化标签库
			JSTL的SQL标签库
			JSTL的函数标签库
			JSTL的XML标签库
		JSTL的核心标签库
			1、导入jar包
			2、声明jstl标签库的引入
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			3、内容：
				基本标签
					<c:out value="数据" default="默认值"></c:out>
						数据可以为常量值也可以是EL表达式。
						作用：将数据输出给客户端。
					<c:set var="数据名" value="数据值" scope="作用域"></c:set>
						作用：存储数据到作用域对象中
						var：表示存储的键名
						value：表示存储的数据
						scope：表示要存储的作用域对象 page request session application
					<c:remove var="键名" scope="作用域"/>
						作用：删除作用域中的指定键的数据
						var:表示要删除的键的名字
						scope:表示要删除的作用域（可选）
						注意：
							如果在不指定作用域的情况使用该标签删除数据，会将四个作用域对象中符合要求的数据全部删除
				
				逻辑标签：
					<c:if text="${表达式}">
						前端代码
					</c:if>
						作用：进行逻辑判断，相当于java代码的单分支判断
						注意：
							逻辑判断标签需要依赖与EL的逻辑运算，也就是表达式中涉及到的数据必须从作用域中获取
					<c:choose>
						<c:when test="">执行内容</c:when>
						<c:when test="">执行内容</c:when>
						...
						<c:otherwise>执行内容</c:otherwise>
					</c:choose>
						作用：用来进行多条件的逻辑判断，类似java中的多分支语句
						注意：
							条件成立只会执行一次，都不成立则执行otherwise
							
				循环标签：
					<c:forEach begin="1" end="4" step="1">
						循环体
					</c:forEach>
						作用：
							循环内容进行处理
						使用：
							begin:声明循环开始位置
							end:循环声明结束位置
							step:设置每次增加的长度
							varStatus:声明变量记录每次循环的数据（角标、次数、是否是第一次循环、是否是最后一次循环）
								注意：数据存储在作用域中，需要使用EL表达式获取
								例如：
									${vs.index}--${vs.count }--${vs.first }--${vs.last }
							items:声明要遍历的对象，结合EL表达式获取对象
							var:声明变量记录每次循环的结果。存储在作用域中，需要使用EL表达式获取

 --%>
</head>
<body>
<!-- 基本标签学习 -->
<h3>基本标签学习</h3>
<c:out value="哈哈"></c:out><br>
<% request.setAttribute("str","今天天气真好"); %>
<c:out value="${str }"></c:out><br>
<c:out value="${str2 }" default="默认值"></c:out>
<br>
<c:set var="hello" value="hello pageContext" scope="page"></c:set>
<c:set var="hello" value="hello request" scope="request"></c:set>
<c:out value="${hello }"></c:out>
<br>
<c:remove var="hello" scope="page"/>
<c:out value="${hello }"></c:out>
<hr>


<!-- 逻辑标签学习 -->
<h3>逻辑标签学习</h3>
<!-- 传统方式 -->
<%
	int a = 4;
	if(a>3) {
%>
<b>今天天气不错</b><br>
<%
	}
%>
<!-- jstl方式 -->
<%-- request.setAttribute("a",4); --%>
<c:set var="a" value="4"></c:set>
<c:if test="${a>3 }">
	<i>今天天气不错</i>
</c:if>
<br>
<c:set var="score" value="85"></c:set>
<c:choose>
	<c:when test="${score>=90 }">
		<i>得了个A</i>
	</c:when>
	<c:when test="${score>=80 }">
		<i>得了个B</i>
	</c:when>
	<c:when test="${score>=70 }">
		<i>得了个C</i>
	</c:when>
	<c:otherwise>
		<i>得了个D</i>
	</c:otherwise>
</c:choose>
<hr>


<!-- 循环标签学习 -->
<h3>循环标签学习</h3>
<!-- 传统方式 -->
<table border="1px">
	<tr>
		<td>课程名称</td>
		<td>教师</td>
		<td>价格</td>
		<td>重要性</td>
	</tr>
	<%
		for(int i = 0; i < 3; i++) {
	%>
	<tr>
		<td>java</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
	</tr>
	<%
		}
	%>
</table>
<!-- 使用jstl方式完成循环 -->
<c:forEach begin="1" end="4" step="2" varStatus="vs">
	${vs.index}--${vs.count }--${vs.first }--${vs.last }<br>
</c:forEach>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	request.setAttribute("list",list);
	
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("a1","哈哈哈");
	map.put("b1","嘿嘿嘿");
	request.setAttribute("map",map);
	
%>
<c:forEach items="${list }" var="str">
	${str }<br>
</c:forEach>
<table border="1px">
	<tr>
		<td>课程名称</td>
		<td>教师</td>
		<td>价格</td>
		<td>重要性</td>
	</tr>
<c:forEach items="${list }" var="s">
	<tr>
		<td>${s }</td>
		<td>${s }</td>
		<td>${s }</td>
		<td>${s }</td>
	</tr>
</c:forEach>
</table>

<c:forEach items="${map }" var="m">
	${m.key }---${m.value }<br>
</c:forEach>

</body>
</html>