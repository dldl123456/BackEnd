package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();  //获取输出管道
		pw.write("解析请求头信息：" + "<br />");
		
		Enumeration<String> enums = request.getHeaderNames();   //获取请求头信息的键名 比如 host
		while(enums.hasMoreElements()){
			 String name= enums.nextElement();
			 String value= request.getHeader(name);  //根据名称取值
			 
			 pw.write(name + "：" + value + "<br />");
		}
		
		pw.flush();
		pw.close();
	}

	/**
	 * servlet初始化方式
	 * ServletConfig对象可以获取servlet的配置参数信息
	 * init方法执行一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		/*String username = config.getInitParameter("username");
		System.out.println(username);*/
		
		System.out.println(config.getServletName());
		
		Enumeration<String> emus = config.getInitParameterNames();
		while(emus.hasMoreElements()){
			String en = emus.nextElement();
			String value = config.getInitParameter(en);
			System.out.println(en + "：" +value);
		}
	}
}
