package com.itzzb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itzzb.pojo.User;
import com.itzzb.service.UserService;

public class RegisterServlet extends HttpServlet{
	private UserService userService=new UserService();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			User user=new User(); 
			user.setUname("zs");
			user.setUpass("123");
			user.setSex("女");
			user.setAddress("上海市黄浦区!!!!");
			boolean flag=userService.register(user);
			if(flag){
				resp.getWriter().write("注册 成功");
			}else{
				resp.getWriter().write("注册 失败");
			}
			
			
			
			
			
		}
		
		
		
}
