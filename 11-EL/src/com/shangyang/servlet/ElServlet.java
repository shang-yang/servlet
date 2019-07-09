package com.shangyang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shangyang.pojo.Address;
import com.shangyang.pojo.User;

/**
 * 问题
 * 		在servle进行请求处理后，使用作用域对象作为数据流转的载体。将数据流转给对应的jsp文件
 * 		如何在jsp中获取作用域中的数据呢？
 * 使用
 * 		传统方式：在jsp页面中使用java脚本段语句。
 */
@WebServlet("/ElServlet")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// 处理请求信息
		System.out.println(uname + ":" + pwd);
		// 响应处理结果
			// 使用request作用域进行数据流转
				// 普通字符串
			req.setAttribute("str", "今天的天气很清爽，适合学习！");
				// 对象类型
			User u = new User(1,"王源","抽烟",new Address("山西","临汾","尧都区"));
			req.setAttribute("user", u);
				// 集合类型
					// List集合
						// 存储普通字符
						List<String> list = new ArrayList<String>();
						list.add("zzh");
						list.add("关小彤");
						list.add("刘诗诗");
						req.setAttribute("list", list);
						// 存储对象
						User u2 = new User(2,"鼓励那渣","看电影",new Address("新疆","塔里木","wakanda"));
						List<User> list2 = new ArrayList<User>();
						list2.add(u2);
						req.setAttribute("list2", list2);
					// Map集合
						// 存储普通字符
						Map<String,String> map = new HashMap<String,String>();
						map.put("a", "北京");
						map.put("b", "上海");
						map.put("c", "深圳");
						req.setAttribute("map", map);
						// 存储对象
						Map<String,User> map2 = new HashMap<String,User>();
						map2.put("a1", u2);
						req.setAttribute("map2", map2);
				
				// 空值判断
				req.setAttribute("s", "");
				req.setAttribute("s1", new User());
				req.setAttribute("s2", new ArrayList());
				req.setAttribute("s3", new HashMap());
			// 请求转发
		req.getRequestDispatcher("el.jsp").forward(req, resp);
			// 请求重定向
	}
}
