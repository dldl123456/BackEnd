package com.itzzb.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MySessionListener implements HttpSessionListener{
	private int count=0;
	//当session被创建的时候此方法自动调用
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		count++;
		//application  全局作用域对象 作用域整个服务器  整个服务器共享的一个对象
		//通过session事件对象拿到session对象
		HttpSession session=event.getSession();
		ServletContext application=session.getServletContext();
		application.setAttribute("count",count);
		
	}
	//当session销毁的时候此方法自动调用
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		count--;
		HttpSession session=event.getSession();
		ServletContext application=session.getServletContext();
		application.setAttribute("count",count);
	}
}
