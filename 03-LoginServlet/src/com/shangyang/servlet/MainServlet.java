package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shangyang.pojo.User;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// 设置请求编码格式
    		req.setCharacterEncoding("utf-8");
    	// 设置响应编码格式
    	resp.setContentType("text/html;charset=utf-8");
    	// 获取请求数据
    		// 获取session中的数据
    		User u = (User) req.getSession().getAttribute("user");
    		// 获取网页浏览次数
    		int num = (int) this.getServletContext().getAttribute("num");
    	resp.getWriter().write("<html>");
    	resp.getWriter().write("<head>");
    	resp.getWriter().write("</head>");
    	resp.getWriter().write("<body>");
    	resp.getWriter().write("<h3>欢迎" + u.getUname() + "访问xxx系统</h3>");
    	resp.getWriter().write("当前网页浏览次数为：" + num);
    	resp.getWriter().write("<hr>");
    	resp.getWriter().write("<form action='show' method='get'>");
    	resp.getWriter().write("<input type='submit' value='查看个人信息'>");
    	resp.getWriter().write("</form>");
    	resp.getWriter().write("</body>");
    	resp.getWriter().write("</html>");
    }

}
