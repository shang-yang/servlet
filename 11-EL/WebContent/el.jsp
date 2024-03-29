<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shangyang.pojo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 使用传统方式获取作用域对象的数据 -->
<h3>传统方式获取</h3>
<b><%=request.getParameter("uname") %></b><br>
<b><%=request.getAttribute("str") %></b><br>
<b><%=((User)request.getAttribute("user")).getAddr().getCity() %></b><br>
<b><%=((ArrayList)request.getAttribute("list")).get(2) %></b><br>
<b><%=((ArrayList<User>)request.getAttribute("list2")).get(0).getAddr().getCity() %></b><br>
<b><%=((HashMap)request.getAttribute("map")).get("c") %></b>
<b><%=((HashMap<String,User>)request.getAttribute("map2")).get("a1").getAddr().getPre() %></b>
<%-- 
	传统方式获取作用域数据：
		缺点一：导入包
		缺点二：需要强转
		缺点三：获取数据的代码过于麻烦
		
	使用EL表达式获取作用域数据：
		作用：获取作用域对象中的数据。
			注意：获取的是 pageContext、request、session、application四个对象中的数据，其他数据一概不理会。
				找到了则获取返回，找不到则什么都不做，也不报错。
			语法：
				${表达式}
				表达式：
					获取请求数据
						request对象 存储了请求数据 ---> param.键名			返回值
						request对象 存储了请求数据 ---> paramvalues.键名		返回的是数组
					通过setAttribute方法存储到作用域对象中的数据
						${键名}	返回键名所对应的值。
						注意：
							如果存储的是普通字符串则直接返回
							如果存储的是对象，则返回的是对象
											获取对象中的数据：
												普通对象
													${键名.属性名.属性名...}
												集合对象
													list集合 --> ${键名[角标]}
													map集合	--> ${键名.map集合存储的键名}
		作用域查找顺序：
			默认查找顺序：
			pageContext --> request --> session -->application
			注意：
				每次查找都是从小到大进行查找，找到了则获取，不再继续查找。
			指定查找：
				${pageScope.键名}
				${requestScope.键名}
				${sessionScope.键名}
				${applicationScope.键名}
				
		EL表达式的逻辑运算:
			${逻辑表达式}：&&  ||  !
			${算数表达式}：+ - * /
			${关系表达式}：> < >== <== == != %
			特殊：
				三目运算
			注意：
				+表示加法运算，不表示字符连接。使用EL表达式进行字符连接会报错。
				
				
		EL的空值判断:
			${empty 键名}
			作用：
				判断键名对象的值是否存有数据。
				
		EL获取请求头数据和Cookie数据
			请求头数据：
				${header}	-->		返回所有的请求头数据
				${header["键名"]} -->返回指定的键名的请求头数据
				${headerValues["键名"]} --> 返回指定的键名（同键不同值）的值的数组
			获取Cookie数据：
				${cookie} --> 返回存储了所有的cookie对象的map集合
				${cookie.键名} --> 返回指定的cookie对象
				${cookie.键名.name} --> 返回指定的cookie对象存储的数据键名
				${cookie.键名.value} --> 返回指定的cookie对象存储的数据的值

 --%>

<!-- 使用EL表达式获取作用域对象数据 -->
<h3>EL表达式获取获取</h3>
<b>${param.uname}</b><br>
<b>${str}</b><br>
<b>${user.addr.town }</b><br>
<b>${list[2] }</b><br>
<b>${list2[0].addr.pre }</b><br>
<b>${map.c }</b>
<b>${map2.a1.addr.city }</b>
<hr/>


<!-- EL的作用域查找顺序 -->
<h3>EL的作用域查找顺序</h3>
<%
	pageContext.setAttribute("hello","hello pageContext");
	request.setAttribute("hello","hello request");
	session.setAttribute("hello","hello session");
	application.setAttribute("hello","hello application");
%>
${pageScope.hello}---${requestScope.hello}---${sessionScope.hello}---${applicationScope.hello}

<hr>
<!-- EL表达式的逻辑运算 -->
<h3>EL表达式的逻辑运算</h3>
${1+200 }--${1*2 }--${4/2 }--${4-2 }--${4%3 }--${4==4 }--${4>2 }--${1==1?'男':'女' }

<hr>
<!-- EL表达式的空值判断 -->
<h3>EL表达式的空值判断</h3>
${empty s }--${empty s1 }--${empty s2 }--${empty s3 }
<hr>
<!-- EL获取请求头数据和Cookie数据 -->
<h3>EL获取请求头数据和Cookie数据</h3>
${header["user-agent"] }--${headerValues["accept-language"][0] }<br><br>
${cookie }--${cookie.JSESSIONID }---${cookie.JSESSIONID.name }---${cookie.JSESSIONID.value }

</body>
</html>