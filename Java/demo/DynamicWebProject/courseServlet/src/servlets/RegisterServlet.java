package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String psw = req.getParameter("password");
		String sex = req.getParameter("sex");
		String[] loves = req.getParameterValues("loves");
		String love = "";
		
		for(String lv:loves){
			love = "," + lv + love;
		}
		
		User user=new User(userName, psw, sex, love.substring(1));
		
		boolean success = userService.register(user);
		
		if (success) {
			resp.sendRedirect("login.html");  //页面跳转
		} else {
			resp.sendRedirect("register.html");
		}
	}
}
