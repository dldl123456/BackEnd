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

		// 建立连接(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void update() throws SQLException {

		// 建立连接(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void insert() throws SQLException {

		// 建立连接(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}

	public static void query() throws SQLException {

		// 建立连接(Connection)
		Connection conn = DBUtil.getConnection();

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
		DBUtil.close(conn);

	}
}
