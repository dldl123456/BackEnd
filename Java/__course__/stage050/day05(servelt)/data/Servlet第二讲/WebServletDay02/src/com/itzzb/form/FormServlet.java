package com.itzzb.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//��������ҳ������ı����ʽ
		req.setCharacterEncoding("UTF-8");
		//getParameter("uname")����form����name����ֵ ����ȡ��Ӧ��valueֵ
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		String sex=req.getParameter("sex");
		String city=req.getParameter("city");
		//�����ַ������� һ����Ը�ѡ���ж��ֵ�����~
		String[] hobbys=req.getParameterValues("hobby");
		System.out.println("�û���:"+uname);
		System.out.println("����:"+upass);
		System.out.println("�Ա�:"+sex);
		System.out.println("����:"+city);
		for(int i=0;i<hobbys.length;i++){
			System.out.print("����"+(i+1)+":"+hobbys[i]+",");
		}
		System.out.println("");
		
	}
	
	
	
	
	
}
