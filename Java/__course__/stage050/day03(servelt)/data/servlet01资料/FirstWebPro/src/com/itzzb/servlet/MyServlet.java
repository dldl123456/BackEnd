package com.itzzb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	//service�������û�����ǰservlet��ʱ��˷����Զ�������
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳ�ϴ�ӡ��Ϣ
		response.getWriter().write("hello world servlet~~~");
		System.out.println("myServlet��������!!!");
	}
}
