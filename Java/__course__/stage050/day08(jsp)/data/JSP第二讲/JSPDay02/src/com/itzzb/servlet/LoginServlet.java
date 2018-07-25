package com.itzzb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		
		if("admin".equals(uname)&&"admin".equals(upass)){
			Cookie cookie1=new Cookie("uname", uname);
			cookie1.setMaxAge(3600);
			resp.addCookie(cookie1);
			resp.sendRedirect("index.jsp");
		}
	}
	
	
	
	
	
}
