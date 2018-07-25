package com.itzzb.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/xmlServlet")
public class XmlServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		InputStream ins=XmlServlet.class.getResourceAsStream("test.xml");//字节流
		//将字节流转换成字符流
		BufferedReader br=new BufferedReader(new InputStreamReader(ins,"UTF-8"));
		StringBuilder xml=new StringBuilder();
		String line=null;
		while((line=br.readLine())!=null){
			xml.append(line+"\r\n");
		}
		System.out.println(xml.toString());
		resp.getWriter().write(xml.toString());
		
		
		
		
		
		
		
	}
}
