package com.zhizuobiao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	static String USERNAME;
	static String PASSWORD;
	static String DB_URL;

	static {

		try {
			Properties prop = new Properties();
			InputStream ins = DBUtil.class.getResourceAsStream("/db.properties");

			prop.load(ins);

			USERNAME = prop.getProperty("db_username");
			PASSWORD = prop.getProperty("db_password");
			DB_URL = prop.getProperty("db_url");

			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
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
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
