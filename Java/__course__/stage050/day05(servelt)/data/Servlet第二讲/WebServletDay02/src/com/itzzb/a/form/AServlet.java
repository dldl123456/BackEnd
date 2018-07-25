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
		//处理代码
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("欢迎超链接访问我们~~~~");
		//getParameter("uname")从页面上获取参数名为uname的值
		String uname=req.getParameter("uname");//
		String upass=req.getParameter("upass");
		String sex=req.getParameter("sex");
		System.out.println("用户名:"+uname);
		System.out.println("密码:"+upass);
		System.out.println("性别:"+sex);
		
		
		
		
		
		
		
		
		
		
	}
}
