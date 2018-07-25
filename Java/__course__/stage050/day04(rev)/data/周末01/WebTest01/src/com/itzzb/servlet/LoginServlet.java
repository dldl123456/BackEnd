package com.itzzb.servlet;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzzb.service.UserService;
public class LoginServlet extends HttpServlet{

	private UserService userService=new UserService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名:");
		String uname=sc.next();
		System.out.println("请输入密码:");
		String upass=sc.next();
		boolean flag=userService.login(uname,upass);
		if(flag){
			resp.getWriter().write("登录成功~~~");
		}else{
			resp.getWriter().write("登陆失败!!!");
		}

	}	
}
