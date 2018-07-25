package com.zhizuobiao.class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdbc
 *
 */
public class Demo1 {
	// 通过JDBC操作数据库——步骤：
	// 第1步：注冊驱动 (仅仅做一次)
	// 第2步：建立连接(Connection)
	// 第3步：创建运行SQL的语句(Statement)
	// 第4步：运行语句
	// 第5步：处理运行结果(ResultSet)
	// 第6步：释放资源

	static String USERNAME = "root";
	static String PASSWORD = "123456";
	static String DB_URL = "jdbc:mysql://localhost:3306/java0206?useUnicode=true&characterEncoding=UTF-8";

	// CREATE TABLE `person` (
	// `id` int(11) NOT NULL auto_increment,
	// `name` varchar(20) NOT NULL,
	// `age` TINYINT unsigned,
	// PRIMARY KEY (`id`)
	// ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	public static void main(String[] args) {

		execute();
	}

	public static void execute() {
		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 建立连接(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = "CREATE TABLE `person` (" //
					+ "`id` int(11) NOT NULL auto_increment," //
					+ "`name` varchar(20) NOT NULL," //
					+ "`age` TINYINT unsigned," //
					+ "PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
//			String sql =  "create database testaaeee;";

			// 创建运行SQL的语句(Statement)
			Statement statement = conn.createStatement();

			// 运行语句
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// 释放资源
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete() {
		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 建立连接(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// 要插入的数据
			int id = 32;

			// delete from user where id = 32
			String sql = "delete from user where id = " + id;

			// 创建运行SQL的语句(Statement)
			Statement statement = conn.createStatement();

			// 运行语句
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// 释放资源
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update() {

		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 建立连接(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// 要插入的数据
			int id = 321;
			String name = "职坐标";
			Date birthday = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// update user set name='asdf',birthday='2018-01-23' where id =321
			String sql = "update user set name='" + name + "',birthday='" + sdf.format(birthday) + "' where id=" + id;

			// 创建运行SQL的语句(Statement)
			Statement statement = conn.createStatement();

			// 运行语句
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// 释放资源
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert() {
		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 建立连接(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// 要插入的数据
			int id = 2;
			String name = "meixi";
			Date birthday = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// insert into user(id,name,birthday) values(3,'eee','2018-01-23')
			String sql = "insert into user(id,name,birthday) values(" + id + ",'" + name + "','" + sdf.format(birthday)
					+ "')";

			// 创建运行SQL的语句(Statement)
			Statement statement = conn.createStatement();

			// 运行语句
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// 释放资源
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void query() {
		try {
			// 注冊驱动 (仅仅做一次)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 建立连接(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = "select * from user";

			// 创建运行SQL的语句(Statement)
			Statement statement = conn.createStatement();

			// 运行语句
			ResultSet rs = statement.executeQuery(sql);

			// 处理运行结果(ResultSet)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");

				System.out.println(id + " , " + name + " , " + birthday);
			}

			// 释放资源
			rs.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
