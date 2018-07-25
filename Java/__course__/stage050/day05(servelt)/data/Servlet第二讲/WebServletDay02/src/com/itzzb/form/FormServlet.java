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
		//设置请求页面参数的编码格式
		req.setCharacterEncoding("UTF-8");
		//getParameter("uname")根据form表单的name属性值 来获取对应的value值
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		String sex=req.getParameter("sex");
		String city=req.getParameter("city");
		//返回字符串数组 一般针对复选框有多个值的情况~
		String[] hobbys=req.getParameterValues("hobby");
		System.out.println("用户名:"+uname);
		System.out.println("密码:"+upass);
		System.out.println("性别:"+sex);
		System.out.println("城市:"+city);
		for(int i=0;i<hobbys.length;i++){
			System.out.print("爱好"+(i+1)+":"+hobbys[i]+",");
		}
		System.out.println("");
		
	}
	
	
	
	
	
}
