package com.shangyang.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig对象学习
 * 		问题：
 * 			如何获取在web.xml中给每个servlet单独配置的数据呢？
 * 		解决：
 * 			使用ServletConfig对象
 * 		使用：
 * 			获取ServletConfig对象
 * 			获取web.xml中的配置
 */

public class ServletConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 获取ServletConfig对象
			ServletConfig sc = this.getServletConfig();
			// 获取web.xml中的配置数据
			String con = sc.getInitParameter("name");
			System.out.println(con);
		}
}
