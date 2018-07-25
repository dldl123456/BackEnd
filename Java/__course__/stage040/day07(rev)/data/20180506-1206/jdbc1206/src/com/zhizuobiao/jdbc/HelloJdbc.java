package com.zhizuobiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhizuobiao.entity.Student;

// com.zhizuobiao.jdbc.HelloJdbc --> �ࣨjava�ࣩ
public class HelloJdbc {

	// ���ݿ��������Ϣ
	// 1.�˺� --> root
	// 2.���� --> 123456
	// 3.���ݿ���������ͬ�����ݿ⣬�������ǲ�ͬ�ģ�
	// mysql --> com.mysql.jdbc.Driver
	// ���ݿ��������������jdk���档�����ݿ��ṩ�ģ�
	// ������Ҫȥ���أ�����ӵ��ҵĹ����У���jar�ķ�ʽ��
	// 4.���ʵ����ݿ��ַ��url��
	// jdbc:mysql://127.0.0.1:3306/web96+����
	// Э��/��ַ/�˿�/���ݿ�����
	// 127.0.0.1 = localhost
	// Э�飨http,dns,dhcp,stmp,ftp,https,pop3...��

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
		// ����
		// 1.��������
		try {
			Class.forName(driver);

			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql��ִ�е�sql�ַ�����
			String sql = "select * from student";
			// 4.����ִ��sql���Ķ���
			Statement statement = conn.createStatement();
			// 5.ִ�в�ѯ������ResultSet���������
			ResultSet rs = statement.executeQuery(sql);
			// 6.���������
			while (rs.next()) { // �ж���û�м�¼��һ��ѭ������һ�м�¼
				// ��ȡ������е�����
				// mysql> select * from student;
				// +----+------+------+------+----------+
				// | id | name | age | sex | school |
				// +----+------+------+------+----------+
				// | 1 | ���� | 18 | �� | ��ϢѧԺ |
				// | 2 | ���� | 20 | Ů | ��ѧԺ |
				// | 3 | С�� | 18 | Ů | ����ѧԺ |
				// +----+------+------+------+----------+

				// 5�У�3��
				// sql�Ĳ�ͬ�����ؽ����Ҳ��ͬ
				// ��ȡ�������е�����
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String school = rs.getString("school");

				// ��װstudent����
				Student stu = new Student();
				stu.setAge(age);
				stu.setId(id);
				stu.setName(name);
				stu.setSchool(school);
				stu.setSex(sex);

				// ��ӡ���
				System.out.println(stu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.�ر�����
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
		// ����
		// 1.��������
		try {
			Class.forName(driver);

			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql��ִ�е�sql�ַ�����
			String sql = "delete from student where id = 4";
			// 4.����ִ��sql���Ķ���
			Statement statement = conn.createStatement();
			// 5.ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н����" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.�ر�����
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
		// ����
		// 1.��������
		try {
			Class.forName(driver);

			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql��ִ�е�sql�ַ�����
			String sql = "update student set sex = \"Ů\" where name = \"��ʿ\"";
			// 4.����ִ��sql���Ķ���
			Statement statement = conn.createStatement();
			// 5.ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н����" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.�ر�����
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
		// ����
		// 1.��������
		try {
			Class.forName(driver);

			// java�ַ���ת��
			String test = " \"\" \\ \\\\ ";

			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, username, password);
			// 3.sql��ִ�е�sql�ַ�����
			String sql = "insert into student(name,age,sex,school) values(\"��ʿ\",18,\"��\",\"NBAѧԺ\")";
			// 4.����ִ��sql���Ķ���
			Statement statement = conn.createStatement();
			// 5.ִ��
			int code = statement.executeUpdate(sql);
			System.out.println("����ִ�н����" + code);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 6.�ر�����
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
