package com.itzzb.a.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�������
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("��ӭ�����ӷ�������~~~~");
		//getParameter("uname")��ҳ���ϻ�ȡ������Ϊuname��ֵ
		String uname=req.getParameter("uname");//
		String upass=req.getParameter("upass");
		String sex=req.getParameter("sex");
		System.out.println("�û���:"+uname);
		System.out.println("����:"+upass);
		System.out.println("�Ա�:"+sex);
		
		
		
		
		
		
		
		
		
		
	}
}
