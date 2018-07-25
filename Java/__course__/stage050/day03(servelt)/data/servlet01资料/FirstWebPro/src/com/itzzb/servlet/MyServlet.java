package com.itzzb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	//service方法，用户请求当前servlet的时候此方法自动被调用
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在网页上打印消息
		response.getWriter().write("hello world servlet~~~");
		System.out.println("myServlet被访问了!!!");
	}
}
