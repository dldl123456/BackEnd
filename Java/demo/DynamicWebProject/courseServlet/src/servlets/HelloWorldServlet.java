package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet implements Servlet {

	@Override
	public void init(ServletConfig paramServletConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * service 服务
	 * ServletRequest 接收客户端请求信息
	 * ServletResponse 响应客户端(输出到浏览器)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("xxx");
		
		//接收客户端
		String username = req.getParameter("username");
		
		//输出到浏览器
		PrintWriter pw = res.getWriter();  //获取输出管道
		pw.println("hello world " + username);
		pw.flush();  //刷新
		pw.close();  //关闭
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
