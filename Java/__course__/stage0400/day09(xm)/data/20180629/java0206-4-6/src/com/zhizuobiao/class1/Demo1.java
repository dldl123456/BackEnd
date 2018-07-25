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
	// ͨ��JDBC�������ݿ⡪�����裺
	// ��1����ע������ (������һ��)
	// ��2������������(Connection)
	// ��3������������SQL�����(Statement)
	// ��4�����������
	// ��5�����������н��(ResultSet)
	// ��6�����ͷ���Դ

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
			// ע������ (������һ��)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// ��������(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = "CREATE TABLE `person` (" //
					+ "`id` int(11) NOT NULL auto_increment," //
					+ "`name` varchar(20) NOT NULL," //
					+ "`age` TINYINT unsigned," //
					+ "PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
//			String sql =  "create database testaaeee;";

			// ��������SQL�����(Statement)
			Statement statement = conn.createStatement();

			// �������
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// �ͷ���Դ
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete() {
		try {
			// ע������ (������һ��)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// ��������(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// Ҫ���������
			int id = 32;

			// delete from user where id = 32
			String sql = "delete from user where id = " + id;

			// ��������SQL�����(Statement)
			Statement statement = conn.createStatement();

			// �������
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// �ͷ���Դ
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update() {

		try {
			// ע������ (������һ��)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// ��������(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// Ҫ���������
			int id = 321;
			String name = "ְ����";
			Date birthday = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// update user set name='asdf',birthday='2018-01-23' where id =321
			String sql = "update user set name='" + name + "',birthday='" + sdf.format(birthday) + "' where id=" + id;

			// ��������SQL�����(Statement)
			Statement statement = conn.createStatement();

			// �������
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// �ͷ���Դ
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert() {
		try {
			// ע������ (������һ��)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// ��������(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// Ҫ���������
			int id = 2;
			String name = "meixi";
			Date birthday = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			// insert into user(id,name,birthday) values(3,'eee','2018-01-23')
			String sql = "insert into user(id,name,birthday) values(" + id + ",'" + name + "','" + sdf.format(birthday)
					+ "')";

			// ��������SQL�����(Statement)
			Statement statement = conn.createStatement();

			// �������
			int code = statement.executeUpdate(sql);

			System.out.println("code:" + code);

			// �ͷ���Դ
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void query() {
		try {
			// ע������ (������һ��)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// ��������(Connection)
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = "select * from user";

			// ��������SQL�����(Statement)
			Statement statement = conn.createStatement();

			// �������
			ResultSet rs = statement.executeQuery(sql);

			// �������н��(ResultSet)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");

				System.out.println(id + " , " + name + " , " + birthday);
			}

			// �ͷ���Դ
			rs.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
