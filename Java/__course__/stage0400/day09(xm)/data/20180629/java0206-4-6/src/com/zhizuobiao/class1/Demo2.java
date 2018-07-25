package com.zhizuobiao.class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdbc
 *
 */
public class Demo2 {
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

		query();
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
			int id = 321;

			// delete from user where id = 32
			String sql = "delete from user where id = ?";

			// 创建运行SQL的语句(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			// 问号的位置，从1开始
			ps.setInt(1, id);

			// 运行语句
			int code = ps.executeUpdate(); // ***重点注意地方***

			System.out.println("code:" + code);

			// 释放资源
			conn.close();

		} catch (Exception e) {
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
			int id = 22;
			String name = "职坐标";
			Date birthday = new Date();

			// update user set name='asdf',birthday='2018-01-23' where id =321
			String sql = "update user set name=?,birthday= ? where id= ?";

			// 创建运行SQL的语句(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));
			ps.setInt(3, id);

			// 运行语句
			int code = ps.executeUpdate();

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
			int id = 100;
			String name = "meixi";
			Date birthday = new Date();

			// insert into user(id,name,birthday) values(3,'eee','2018-01-23')
			String sql = "insert into user(id,name,birthday) values( ?,?,?)";

			// 创建运行SQL的语句(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, new java.sql.Date(birthday.getTime()));

			// 运行语句
			int code = ps.executeUpdate();

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

			String sql = "select * from user where name = ?";

			// 创建运行SQL的语句(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "abc");

			// 运行语句
			ResultSet rs = ps.executeQuery();

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
