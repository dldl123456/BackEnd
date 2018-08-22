package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * get请求
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(1);  //session声明周期
		
		String name = "张三";
		
		resp.setContentType("text/html; charset=utf-8");
		
		//输出到浏览器（字符流）
		PrintWriter pw = resp.getWriter();  //获取输出管道
		pw.write(name + "<br />");
		
		resp.getWriter().write(name);
		resp.getWriter().write(session.getId());
		System.out.println(session.isNew());
		
		pw.flush();
		pw.close();
	}

}
