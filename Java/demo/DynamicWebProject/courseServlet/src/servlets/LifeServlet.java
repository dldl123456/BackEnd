package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeServlet() {
    	//实例化类运行构造方法（实例化Servlet对象中一直驻留在内存）
    	System.out.println("Servlet构造方法");
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet处理...");  //只要不停请求，就会不停处理(请求响应)
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	//重写父类方法
	@Override
	public void destroy() {
		//tomcat结束时销毁 ==> 释放资源
		System.out.println("Servlet 销毁时执行");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet 初始化方法...只执行一次。。。。");
	}

	
}
