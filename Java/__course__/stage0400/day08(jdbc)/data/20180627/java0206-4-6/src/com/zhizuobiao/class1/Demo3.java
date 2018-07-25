package com.zhizuobiao.class1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * jdbc
 *
 */
public class Demo3 {
	public static void main(String[] args) throws SQLException {

		query();
	}

	public static void delete() throws SQLException {

		// ��������(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void update() throws SQLException {

		// ��������(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void insert() throws SQLException {

		// ��������(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void query() throws SQLException {

		// ��������(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}
}
