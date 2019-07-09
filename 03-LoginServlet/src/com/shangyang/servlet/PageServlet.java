package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	// 设置请求编码格式
    	
    	// 设置响应编码格式
    	arg1.setContentType("text/html;charset=utf-8");
    	// 获取请求信息
    	// 处理请求
    	// 响应处理结果
    		
    	// 获取request作用域数据
    	String str = arg0.getAttribute("str") == null ? "" : arg0.getAttribute("str").toString();
    	System.out.println(str);
    	arg1.getWriter().write("<html>");
    	arg1.getWriter().write("<head>");
    	arg1.getWriter().write("</head>");
    	arg1.getWriter().write("<body>");
    	arg1.getWriter().write("<font color='red' size='20px'>" + str + "</font>");
    	arg1.getWriter().write("<form action='login' method='post' >");
    	arg1.getWriter().write("用户名：<input type='text' name='uname' value=''/><br/>");
    	arg1.getWriter().write("密码：<input type='text' name='pwd' value=''/><br/>");
    	arg1.getWriter().write("<input type='submit' value='登录'/><br/>");
    	arg1.getWriter().write("</form>");
    	arg1.getWriter().write("</body>");
    	arg1.getWriter().write("</html>");
    }
    
    

}
