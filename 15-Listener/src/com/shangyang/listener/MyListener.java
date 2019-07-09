package com.shangyang.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器的使用：
 * 		作用：
 * 			监听作用域对象 request、session、application 的创建、销毁和内容的改变
 * 		
 * 		使用：
 * 			创建一个实现了指定接口的java类
 * 				监听 request -->  ServletRequestListener		监听 request 对象的创建和销毁
 * 				requestInitialized(ServletRequestEvent sre)	// 创建
 * 				requestDestroyed(ServletRequestEvent sre)	// 销毁
 * 					注意：形参可以获取监听的 request 对象
 * 						sre.getServletRequest()
 * 
 * 				监听 request -->  ServletRequestAttributeListener	监听 request作用域数据的变更
 * 				attributeAdded(ServletRequestAttributeEvent srae)
 * 				attributeRemoved(ServletRequestAttributeEvent srae)
 * 				attributeReplaced(ServletRequestAttributeEvent srae)
 * 					注意：形参可以获取被监听的数据
 * 						srae.getName()	获取监听数据的键
 * 						srae.getValue()	获取监听数据的值
 * 				
 * 				监听 session
 * 				
 * 				监听 application
 *			在web.xml中配置监听器类
 *				<listener>
 *					<listener-class>包名.类名</listener-class>
 *				</listener>
 *		
 *		案例：
 *			统计当前在线人数
 *			统计网页浏览次数
 */
@WebListener
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener,HttpSessionListener {

	// request对象销毁
	@Override
    public void requestDestroyed(ServletRequestEvent sre)  {  
		System.out.println("我被销毁了");
    }

	// reuqest对象创建
	@Override
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("我被创建了");
    }
	
	// 监听request作用域数据的添加
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中增加了一条数据" + srae.getName() + ":" + srae.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated tub
		ServletRequestAttributeListener.super.attributeRemoved(srae);
	}
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		ServletRequestAttributeListener.super.attributeReplaced(srae);
	}
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		String a = (String) se.getSession().getAttribute("a");
		System.out.println("session创建"+se.getSession().getId());
	}
}
