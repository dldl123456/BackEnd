package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharsetOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * request ==> 获取客户端请求信息
	 * response ==> 响应客户端请求信息
	 * 
	 * 解决输出中文乱码
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置输出类型,并设置字符编码（默认text/plain）(html默认ISO-8859-1)
		response.setContentType("text/html; charset=utf-8");
		
		//拿到一个输出管道
		PrintWriter pw = response.getWriter();
		
		pw.println("白色");
		
		pw.flush();
		pw.close();
	}

}
