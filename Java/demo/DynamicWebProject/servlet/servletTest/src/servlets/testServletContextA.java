package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testServletContextA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext app1;  //声明全局对象

	/**
	 * get请求
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 * 
	 * ServletContext全局对象
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		app1 = config.getServletContext(); //初始化上下文对象(全局对象)
		app1.setAttribute("uname", "小白");  //给上下文对象uname赋值
	}
	
	

}
