package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetJSONServlet
 */
@WebServlet("/GetJSONServlet")
public class GetJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJSONServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码(告知浏览器用utf-8来解�?)
		response.setContentType("application/json;charset=utf-8");
		//告知response对象中的数据以utf-8的格式解码后再发向浏览器
		response.setCharacterEncoding("utf-8");
		
		//输出�?
		PrintWriter out = response.getWriter();
		out.println(
			"{\"students\": "
				+ "["
					+ "{\"name\": \"zhangsan\", \"password\": \"123456\"}, "
					+ "{\"name\": \"lisi\", \"password\": \"456789\"}"
				+ "]"
			+ "}"
		);
		
		
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
