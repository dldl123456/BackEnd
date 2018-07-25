package com.sky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;  

public class StudentScore {
	public static void main(String[] args) throws Exception {
		//1、加载驱动,注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、创建链接，这个程序最终要操作哪个数据库 
		String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf-8";
		
		//3、链接数据库
		Connection conn = DriverManager.getConnection(url, "root", "root");
		
		//4、创建需要执行的sql语句操作数据库(查询)
		String sql = "SELECT * FROM score";
		
		//5、创建执行这个sql语句的对象，告诉他需要来执行这条语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//执行sql语句，增删改都是用executeUpdate，查询用executeQuery
		//ResultSet是一个结果集，有sql执行的所有记录
		ResultSet rs = stmt.executeQuery();
		
		//获取结果集对象里面的数据
		while(rs.next()){
			String id = rs.getString(1);
			String name = rs.getString(2);
			int chinese = rs.getInt(3);
			int math = rs.getInt(4);
			int english = rs.getInt(5);
			
			System.out.println("Student [id=" + id + ", name=" + name + ", chinese=" + chinese
					+ ", math=" + math + ", english=" + english + "]");
		}
	}
}
