package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * request ==> 获取客户端请求信息
	 * response ==> 响应客户端请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取客户端的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//创建一个session容器(只要有交互，一直存在)
		HttpSession session = request.getSession();
		
		//设置生命周期
		session.setMaxInactiveInterval(3);
		
		//模拟登录
		if("aa".equals(username) && "bb".equals(password)){
			session.setAttribute("user", username);  //把用户名存到session
			//登录成功跳转（在新页面显示用户名）
			response.sendRedirect("success.do");
		} else {
			//输入错误，重新登录
			response.sendRedirect("index.html");
		}
	}

}
