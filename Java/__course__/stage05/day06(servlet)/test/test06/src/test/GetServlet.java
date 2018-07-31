package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码(告知浏览器用utf-8来解�?)
		response.setContentType("text/html;charset=utf-8");
		//告知response对象中的数据以utf-8的格式解码后再发向浏览器
		response.setCharacterEncoding("utf-8");
		
		//输出�?
		PrintWriter out = response.getWriter();
		//把request里面封装的内容以utf-8的格式进行解�?
		request.setCharacterEncoding("utf-8");
		//获取
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");*/
		//如果js进行2次编码，servlet要进�?2次解�?
		String username = URLDecoder.decode(URLDecoder.decode(request.getParameter("username"), "utf-8"), "utf-8");
		String password = URLDecoder.decode(URLDecoder.decode(request.getParameter("password"), "utf-8"), "utf-8");
		
		//判断
		if(username.equals("ccac")&&password.equals("123456")){
			out.println("<p>欢迎" + username + "光临</p>");
		}else{
			out.println("用户名或密码出错");
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
