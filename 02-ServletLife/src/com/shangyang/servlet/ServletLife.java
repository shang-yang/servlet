package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet生命周期：
 * 		1、从第一次调用到服务器关闭
 * 		2、如果Servlet在web.xml中配置了 load-on-startup ，生命周期为从服务器启动到服务器关闭
 * 	注意：
 * 		init方法是对Servlet进行初始化的一个方法，在Servlet第一次加载进内存时执行
 * 		destory方法实在servlet被销毁时执行，也就是服务器关闭时。	
 */
public class ServletLife extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLife() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    /**
     * 初始化方法，在servlet第一次加载内容的时候被调用
     */
    @Override
    public void init() throws ServletException {
    	System.out.println("servlet初始化完成");
    }
    
    
    /**
     * service方法，真正处理请求的方法
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.getWriter().write("servlet life");
    	System.out.println("servlet life");
    }
    
    /**
     * 销毁
     */
    @Override
    public void destroy() {
    	System.out.println("我被销毁了。。。。");
    }
}
