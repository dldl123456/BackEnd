package com.itzzb.disp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.getWriter().write("开始");
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		//得到内部转发的对象
		RequestDispatcher rd=req.getRequestDispatcher("successServlet");
		if("admin".equals(uname)&&"admin".equals(upass)){
			//rd.forward(req,resp);
			rd.include(req,resp);
		}else{
			resp.getWriter().write("用户名和密码错误~~~");
		}
		resp.getWriter().write("结束~~~~");
		
	}
}
