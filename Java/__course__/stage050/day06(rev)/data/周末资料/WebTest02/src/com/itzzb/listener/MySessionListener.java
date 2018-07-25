package com.itzzb.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MySessionListener implements HttpSessionListener{
	private int count=0;
	//��session��������ʱ��˷����Զ�����
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		count++;
		//application  ȫ����������� ����������������  ���������������һ������
		//ͨ��session�¼������õ�session����
		HttpSession session=event.getSession();
		ServletContext application=session.getServletContext();
		application.setAttribute("count",count);
		
	}
	//��session���ٵ�ʱ��˷����Զ�����
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		count--;
		HttpSession session=event.getSession();
		ServletContext application=session.getServletContext();
		application.setAttribute("count",count);
	}
}
