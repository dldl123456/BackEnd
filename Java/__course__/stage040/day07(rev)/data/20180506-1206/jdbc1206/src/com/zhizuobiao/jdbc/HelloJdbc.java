package com.zhizuobiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhizuobiao.entity.Student;

// com.zhizuobiao.jdbc.HelloJdbc --> 类（java类）
public class HelloJdbc {

	// 数据库的配置信息
	// 1.账号 --> root
	// 2.密码 --> 123456
	// 3.数据库驱动（不同的数据库，驱动类是不同的）
	// mysql --> com.mysql.jdbc.Driver
	// 数据库的驱动，并不在jdk里面。是数据库提供的，
	// 所有需要去下载，并添加到我的工程中，以jar的方式。
	// 4.访问的数据库地址（url）
	// jdbc:mysql://127.0.0.1:3306/web96+参数
	// 协议/地址/端口/数据库名称
	// 127.0.0.1 = localhost
	// 协议（http,dns,dhcp,stmp,ftp,https,pop3...）

	static String username = "root";
	static String password = "123456";
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://127.0.0.1:3306/web96";

	public static void main(String[] args) {

		// insert();
		// update();
		// delete();

		query();
	}

	public static void query() {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）
			String sql = "select * from student";
			// 4.创建执行sql语句的对象
			Statement statement = conn.createStatement();
			// 5.执行查询，返回ResultSet（结果集）
			ResultSet rs = statement.executeQuery(sql);
			// 6.遍历结果集
			while (rs.next()) { // 判断有没有记录，一次循环代表一行记录
				// 获取结果集中的数据
				// mysql> select * from student;
				// +----+------+------+------+----------+
				// | id | name | age | sex | school |
				// +----+------+------+------+----------+
				// | 1 | 张三 | 18 | 男 | 信息学院 |
				// | 2 | 李四 | 20 | 女 | 理学院 |
				// | 3 | 小红 | 18 | 女 | 外语学院 |
				// +----+------+------+------+----------+

				// 5列，3行
				// sql的不同，返回结果的也不同
				// 获取具体列中的数据
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String school = rs.getString("school");

				// 封装student对象
				Student stu = new Student();
				stu.setAge(age);
				stu.setId(id);
				stu.setName(name);
				stu.setSchool(school);
				stu.setSex(sex);

				// 打印结果
				System.out.println(stu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.关闭连接
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void delete() {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）
			String sql = "delete from student where id = 4";
			// 4.创建执行sql语句的对象
			Statement statement = conn.createStatement();
			// 5.执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果：" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.关闭连接
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void update() {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）
			String sql = "update student set sex = \"女\" where name = \"勇士\"";
			// 4.创建执行sql语句的对象
			Statement statement = conn.createStatement();
			// 5.执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果：" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.关闭连接
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void insert() {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// java字符串转义
			String test = " \"\" \\ \\\\ ";

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）
			String sql = "insert into student(name,age,sex,school) values(\"勇士\",18,\"男\",\"NBA学院\")";
			// 4.创建执行sql语句的对象
			Statement statement = conn.createStatement();
			// 5.执行
			int code = statement.executeUpdate(sql);
			System.out.println("更新执行结果：" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.关闭连接
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
