package com.itzzb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itzzb.pojo.Student;
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		List<Student> list=new ArrayList<Student>();
		Student stu1=new Student(1,"zs1","123","�Ϻ��л�����");
		Student stu2=new Student(2,"zs2","123","�Ϻ��л�����");
		Student stu3=new Student(3,"zs3","123","�Ϻ��л�����");
		Student stu4=new Student(4,"zs4","123","�Ϻ��л�����");
		Student stu5=new Student(5,"zs5","123","�Ϻ��л�����");
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		HttpSession session=req.getSession();
		session.setAttribute("list", list);
		//1.����ǴӶ�����ʲô���󱣴�list����  ��session  2������
		//2.���ʹ���ڲ�ת����ʲô���󱣴�list���� ��forward  1������  ʹ��������󼴿�
		//req.setAttribute("list",list);
		req.getRequestDispatcher("getData.jsp").forward(req,resp);
		
		
		
		
		
		
		
		
		
	}
}
