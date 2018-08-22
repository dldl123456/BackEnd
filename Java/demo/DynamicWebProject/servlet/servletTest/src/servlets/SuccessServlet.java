package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * request ==> 获取客户端请求信息
	 * response ==> 响应客户端请求（输出）
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置输出（响应）类型,并定义编码
		response.setContentType("text/html; charset=utf-8");
		
		//输出流(字符流)
		PrintWriter pw = response.getWriter();  //response对象响应
		
		HttpSession session = request.getSession();  //实例化session
		
		//如果session对象超时被销毁
		if (session.getAttribute("user") != null) {
			String username = session.getAttribute("user").toString();
			pw.println("欢迎" + "<font color='#f00'>" + username + "</font>");
			pw.println("<a href='loginout.do'>注销</a>");
		} else {
			response.sendRedirect("index.html");
		}
		
	}

}
