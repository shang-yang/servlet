package com.shangyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service方法和doGet方法和doPost方法
 * 		service方法：
 * 			可以处理get/post方式的请求，如果servlet中有servic方法，会优先调用service方法对请求进行处理
 * 		doGet方法
 * 			处理get请求
 * 		doPost方法
 * 			处理post请求
 * 
 * 注意：
 * 		如果在覆写的service方法中调用了父类的service方法（super.service(arg0,arg1)）,
 * 	则service方法处理完后，会再次根据请求方式相应的 doGe t和 doPost 方法执行
 * 	所以一般情况下啊，不再service中调用父类的方法（不用super.service()）,避免出现405错误。
 * 
 * 
 * Servlet的常见错误
 * 		404 资源未找到
 * 			原因一：在请求地址中的servlet的别名书写错误
 * 			原因二：项目名称拼写错误
 * 		
 * 		500 内部服务器错误
 * 			错误一
 * 				java.lang.ClassNotFoundException: com.shangyang.servlet.xxxxxx
 * 				解决：
 * 					在web.xml中校验servlet类的全限定路径是否拼写错误
 * 			错误二
 * 				因为service方法体的代码执行错误导致
 * 				解决：
 * 					数据错误提示对service方法体中的代码进行错误更改。
 * 		
 * 		405 请求方式不支持
 * 			原因：
 * 				请求方式和servlet中的方法不匹配所造成的。
 * 			解决:
 * 				尽量使用service方法进行请求处理，并且不要在service方法中调用父类的service。
 */

public class ServletMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMethod() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("我是service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }
    
}
