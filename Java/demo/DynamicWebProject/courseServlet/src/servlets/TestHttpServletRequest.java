package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHttpServletRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*System.out.println(req.getServerName());  //服务器名
		System.out.println(req.getServerPort());  //服务器端口
		System.out.println(req.getScheme());  //http
		System.out.println(req.getServletContext());  //上下文对象
		System.out.println(req.getServletPath());  //servlet路径
		System.out.println(req.getContextPath());  //上下文路径(根路径)*/
		
		/*System.out.println(req.getRemoteAddr());  //远程客户端
		System.err.println(req.getLocalAddr());
		System.out.println(req.getMethod());  //获取请求方式
		System.out.println(req.getQueryString());//获取请求参数列表信息*/
		
		//解析请求头信息
		//枚举
		Enumeration<String> enums = req.getHeaderNames();   //获取请求头信息的键名 比如 host
		while(enums.hasMoreElements()){
			 String name= enums.nextElement();
			 String value= req.getHeader(name);  //根据名称取值
			 
			 System.out.println(name + "：" + value);
		}
		System.out.println();
	}

}
