package com.sky.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.dao.StudentScore;
import com.sky.test.Student;

public class QueryScore extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����û������������request.getParameter()�������Ǳ��е�name������ֵ
		//ctrl+1
		String id = request.getParameter("studentId");
		//System.out.println(id);
		
		//����StudentScore�Ķ���,���������ݿ�
		StudentScore ss = new StudentScore();	//������һ������
		
		try {
			Student stu =  ss.queryScore(id);
			//�ڵ�ǰҳ����ʾ��ѯ���Ľ��
			//��request������д�ֵ
			//s������ǰ̨ʹ�ã����������ȡֵ�ģ�stu����������������е�ֵ
			request.setAttribute("s", stu);
			
			//��ҳ��ͣ���ڵ�ǰҳ��--ֻ��ʹ��ת��
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			System.out.println(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
