package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FirstServlet(){
		System.out.println("first servlet 构造方法");
	}

	/**
	 * 服务：
	 * doGet处理get提交方式请求的(<a>,直接从地址栏请求,form method="get" 都属于get请求)
	 * 执行doGet方法
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建一个管道流(字符流)  ==>  输出管道
		PrintWriter pw = resp.getWriter();
		//OutputStream os = resp.getOutputStream();  //字节流，效率低
		
		/*=====   一般用字符流   =====*/
		
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>first page</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<span style='color:#f00'>123123</span>");
		pw.print("</body>");
		pw.print("</html>");
		
		pw.flush();
		pw.close();
	}

	/**
	 * 服务：
	 * doPost处理post提交方式请求的
	 * 执行doPost方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("doPost...");
	}
	
}
