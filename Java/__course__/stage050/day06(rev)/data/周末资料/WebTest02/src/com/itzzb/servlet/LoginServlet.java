package com.itzzb.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		if("admin".equals(uname)&&"admin".equals(upass)){
			HttpSession session=req.getSession();
			session.setAttribute("uname",uname);
			resp.sendRedirect("successServlet");
		}else{
			resp.getWriter().write("<a href='index.html'>ÇëÖØÐÂµÇÂ¼</a>");
		}
	}
}
