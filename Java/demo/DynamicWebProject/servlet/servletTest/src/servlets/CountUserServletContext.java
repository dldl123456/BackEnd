package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountUserServletContext
 */
public class CountUserServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext app;

	/**
	 * get请求
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 * 
	 * ServletContext全局对象
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//访问次数，输出到页面
		response.setContentType("text/html; charset=utf-8");  //定义输出格式，指定输出，响应文档类型，并指定编码
		PrintWriter pw = response.getWriter();  //输出管道
		
		//获取到count（对象类型）==》字符串==》用包装类转成整型
		int count = Integer.parseInt(app.getAttribute("count").toString());
		
		//拿到count的值，加1，再存入ServletContext对象
		app.setAttribute("count", ++count);  //更新ServletContext count属性的值
		
		pw.println("第" + app.getAttribute("count") + "次访问");
		
		
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		app = config.getServletContext();  //容器(全局对象)  ==>  存访问次数
		app.setAttribute("count", 0);  //初始化一个初始值（开始统计次数为1）
	}
	
	

}
