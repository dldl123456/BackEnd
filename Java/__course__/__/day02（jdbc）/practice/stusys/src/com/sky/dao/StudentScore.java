package com.sky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;  

public class StudentScore {
	public static void main(String[] args) throws Exception {
		//1����������,ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ӣ������������Ҫ�����ĸ����ݿ� 
		String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf-8";
		
		//3���������ݿ�
		Connection conn = DriverManager.getConnection(url, "root", "root");
		
		//4��������Ҫִ�е�sql���������ݿ�(��ѯ)
		String sql = "SELECT * FROM score";
		
		//5������ִ�����sql���Ķ��󣬸�������Ҫ��ִ���������
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//ִ��sql��䣬��ɾ�Ķ�����executeUpdate����ѯ��executeQuery
		//ResultSet��һ�����������sqlִ�е����м�¼
		ResultSet rs = stmt.executeQuery();
		
		//��ȡ������������������
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
