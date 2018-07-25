package com.itzzb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		List<User> list=new ArrayList<User>();
		User user1=new User(1,"zs1","123","男","上海市黄浦区");
		User user2=new User(2,"zs2","123","男","上海市黄浦区");
		User user3=new User(3,"zs3","123","男","上海市黄浦区");
		User user4=new User(4,"zs4","123","男","上海市黄浦区");
		User user5=new User(5,"zs5","123","男","上海市黄浦区");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		//将list集合转成json对象的写法
		JSON json=(JSON) JSON.toJSON(list);
		System.out.println(json);
		resp.getWriter().write(json.toString());
		//[{},{},{}]
		
		
	}
}
