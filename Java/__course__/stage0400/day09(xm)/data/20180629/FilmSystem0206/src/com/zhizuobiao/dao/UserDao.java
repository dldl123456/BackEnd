package com.zhizuobiao.dao;

import java.sql.SQLException;

import com.zhizuobiao.entity.User;

public interface UserDao {

	int insert(User user) throws SQLException;

	int update(User user);

	User query(String username, String password) throws SQLException;
}
