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

		query();
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
			int id = 321;

			// delete from user where id = 32
			String sql = "delete from user where id = ?";

			// ��������SQL�����(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			// �ʺŵ�λ�ã���1��ʼ
			ps.setInt(1, id);

			// �������
			int code = ps.executeUpdate(); // ***�ص�ע��ط�***

			System.out.println("code:" + code);

			// �ͷ���Դ
			conn.close();

		} catch (Exception e) {
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
			int id = 22;
			String name = "ְ����";
			Date birthday = new Date();

			// update user set name='asdf',birthday='2018-01-23' where id =321
			String sql = "update user set name=?,birthday= ? where id= ?";

			// ��������SQL�����(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));
			ps.setInt(3, id);

			// �������
			int code = ps.executeUpdate();

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
			int id = 100;
			String name = "meixi";
			Date birthday = new Date();

			// insert into user(id,name,birthday) values(3,'eee','2018-01-23')
			String sql = "insert into user(id,name,birthday) values( ?,?,?)";

			// ��������SQL�����(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, new java.sql.Date(birthday.getTime()));

			// �������
			int code = ps.executeUpdate();

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

			String sql = "select * from user where name = ?";

			// ��������SQL�����(PreparedStatement)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "abc");

			// �������
			ResultSet rs = ps.executeQuery();

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
