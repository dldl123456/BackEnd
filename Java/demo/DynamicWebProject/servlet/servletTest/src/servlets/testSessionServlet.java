package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * get请求
	 * req ==> 获取客户端的请求信息
	 * resp ==> 响应客户端的请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session对象是保存在服务器端，客户端关闭，session没有销毁，真正销毁的世界是sessin的设置生命周期时间之外
		HttpSession session = request.getSession();  //实例化session
		System.out.println(session.getId());  //session唯一id
		
		//设置session生命周期(秒)
		session.setMaxInactiveInterval(10);
		//判断是否是同一个会话(是否是同一个session_id)
		//不同的客户端(浏览器)session不同
		System.out.println(session.isNew());
	}

}
