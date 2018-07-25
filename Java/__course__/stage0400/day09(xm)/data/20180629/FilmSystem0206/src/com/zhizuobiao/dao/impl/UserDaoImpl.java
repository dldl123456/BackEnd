package com.zhizuobiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.entity.User;
import com.zhizuobiao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int insert(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user(username,password,sex,age,mobile,auth) values(?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getSex());
		ps.setInt(4, user.getAge());
		ps.setString(5, user.getMobile());
		ps.setInt(6, user.getAuth());
		int code = ps.executeUpdate();

		DBUtil.close(conn);

		return code;
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public User query(String username, String password) throws SQLException {
		User user = null;

		String sql = "select id from user where username=? and password=?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
		}

		return user;
	}
	
	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		try {
			System.out.println(udi.query("aa", "nn"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
