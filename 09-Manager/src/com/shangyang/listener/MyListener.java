package com.shangyang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener, ServletContextListener {

	// session创建时人数自增
	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
        // 获取ServletContext对象
		ServletContext sc = se.getSession().getServletContext();
		// 获取在线统计人数的变量
		int count = (int)sc.getAttribute("count");
		// 存储
		sc.setAttribute("count", count++);
		System.out.println("session" + count++);
    }

	// session创建时人数自减
	@Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
		
        // 获取ServletContext对象
		ServletContext sc = se.getSession().getServletContext();
		// 获取在线统计人数的变量
		int count = (int)sc.getAttribute("count");
		// 存储
		sc.setAttribute("count", count--);
		System.out.println("session2" + count--);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    // application对象初始化
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("application");
         // 获取application对象
		ServletContext sc = sce.getServletContext();
		 // 在application对象存储变量用来统计在线人数
		sc.setAttribute("count", 0);
    }
	
}
