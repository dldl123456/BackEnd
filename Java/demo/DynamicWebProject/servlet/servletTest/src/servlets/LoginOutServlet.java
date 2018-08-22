package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOutServlet
 */
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * request ==> 获取客户端请求信息
	 * response ==> 响应客户端请求（输出）
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注销session对象
		HttpSession session = request.getSession();
		
		session.invalidate();  //强制销毁
		
		response.sendRedirect("index.html");
	}

}
