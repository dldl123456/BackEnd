package com.zhizuobiao.day3.dao;

import com.zhizuobiao.day3.entity.User;

public interface UserDao {

	int insertUser(User user);

	User getUser(int id);
	
	int deleteUser(int id);
	
	int updateUser(User user);
}
