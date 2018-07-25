package com.lesson.phase4.l0907.l171229;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "";
		
		try {
			//加载数据库驱动
			Class.forName(driver);
			//建立连接
			Connection conn = DriverManager.getConnection(url, user, pwd);
			System.out.println(conn);
			//获取执行sql语句对象
			//Statement st = conn.createStatement();
			//String sql = "select * from student where name = ? ";
			String sql = "select st.name as '姓名' ,sex,su.name '科目',score "
					+ " from student st,subject su,score sc "
					+ " where st.id = sc.student_id and su.id = sc.subject_id";
			PreparedStatement st = conn.prepareStatement(sql);
			//st.setString(1, "zhangsan");
			//执行sql语句
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		
	}
}
