package com.itzzb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzzb.dao.UserDao;
import com.itzzb.pojo.User;
import com.itzzb.util.PageUtil;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{
	private UserDao userDao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.write("<form action='userServlet'>");
		out.write("<input type='submit' value='查询所有用户'>");
		out.write("<form>");
		out.write("<hr>");
		int index=1;
		int count=userDao.getUserCount();
		int countPage=0;
		String page_index=req.getParameter("index");
		if(page_index!=null){
			index=Integer.parseInt(page_index);
		}
		List<User>list=userDao.getUsers(index);
		out.write(list.toString());
		
		if(count%PageUtil.PAGE_SIZE==0){
			countPage=count/PageUtil.PAGE_SIZE;
		}else{
			countPage=count/PageUtil.PAGE_SIZE+1;
		}
		for(int i=0;i<countPage;i++){
			out.write("<a href='userServlet?index="+(i+1)+"'>"+(i+1)+"</a>");
		}
		
		
		
		
	}
}
