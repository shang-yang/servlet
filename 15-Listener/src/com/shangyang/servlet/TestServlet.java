package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name="ts",urlPatterns="/ts")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求信息
		// 处理请求信息
		req.setAttribute("str", "监听学习");
		HttpSession hs = req.getSession(true);
		System.out.println(hs.getId());
		hs.setAttribute("a", "aaaaaa");
		// 响应处理结果
		resp.getWriter().write("this is listener study");
		hs.removeAttribute("a");
	}
}
