package com.zhizuobiao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.dao.UserDao;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	// @Resource
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		WebApplicationContext applicationContext = (WebApplicationContext) getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

		userDao = (UserDao) applicationContext.getBean("userDao");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// WebApplicationContext applicationContext = WebApplicationContextUtils
		// .getWebApplicationContext(getServletContext());

		// User uesr = (User) applicationContext.getBean("user");
		// userDao = (UserDao) applicationContext.getBean("userDao");

		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		User user2 = userDao.getUser(1);

		req.setAttribute("uesr2", user2);
//		req.setAttribute("uesr", uesr);
		req.setAttribute("list", list);
		req.setAttribute("username", "zhizuobao");

		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
	}

}