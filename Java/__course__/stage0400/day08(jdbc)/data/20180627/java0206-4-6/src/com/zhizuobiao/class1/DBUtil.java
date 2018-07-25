package com.zhizuobiao.class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static String USERNAME = "root";
	static String PASSWORD = "123456";
	static String DB_URL = "jdbc:mysql://localhost:3306/java0206?useUnicode=true&characterEncoding=UTF-8";

	static {
		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// 建立连接(Connection)
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
