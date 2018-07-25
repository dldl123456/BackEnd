package com.zhizuobiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhizuobiao.entity.Student;

/**
 * sql注入和解决
 */
public class HelloJdbc2 {

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
		// Statement --> 存在sql注入漏洞
		String sql = "select * from student where id = 1";
		// query(sql + " or 1=1");
		// query(sql );

		// 如何解决？
		// 使用
		// select();

		update();
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
			String sql = "update student set sex = ? ,age=?,school=? where id = ?";
			// 4.创建执行sql语句的对象
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "男");
			ps.setInt(2, 33);
			ps.setString(3, "清华");
			ps.setInt(4, 2);

			// 5.执行
			int code = ps.executeUpdate();
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

	public static void select() {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）
			String sql = "select * from student where name = ? and age = ?";

			// 4.创建执行sql语句的对象,预处理,使用占位符
			PreparedStatement ps = conn.prepareStatement(sql);
			// 给占位符（？）赋值
			// ps.setString(1, "张三" +" or 1=1"); // 解决注入问题

			// 替换第1个？，值=张三，类型，字符串
			ps.setString(1, "张" + "三"); // 第一个参数代表问号的位置，从1开始
			// 替换第2个？，值=18，类型，整形
			ps.setInt(2, 18); // 第一个参数代表问号的位置，从1开始

			// 5.执行查询，返回ResultSet（结果集），记住不要再次传入sql
			ResultSet rs = ps.executeQuery();

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
			
			rs.close();
			
			ps.close();
			
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

	public static void query(String sql) {
		Connection conn = null;
		// 步骤
		// 1.加载驱动
		try {
			Class.forName(driver);

			// 2.创建数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql（执行的sql字符串）

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

}
