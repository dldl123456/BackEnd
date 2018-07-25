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
		//接收用户的请求参数，request.getParameter()参数就是表单中的name的属性值
		//ctrl+1
		String id = request.getParameter("studentId");
		//System.out.println(id);
		
		//创建StudentScore的对象,来操作数据库
		StudentScore ss = new StudentScore();	//创建了一个对象
		
		try {
			Student stu =  ss.queryScore(id);
			//在当前页面显示查询到的结果
			//向request域对象中存值
			//s是留给前台使用，从域对象中取值的，stu是真正存在域对象中的值
			request.setAttribute("s", stu);
			
			//让页面停留在当前页码--只能使用转发
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
