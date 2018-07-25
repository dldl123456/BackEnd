package com.zhizuobiao.dao;

import java.util.List;

import com.zhizuobiao.bean.User;

public interface UserDao {

	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(int id);

	User getUser(int id);

	List<User> getUserList();

	int getCount();
}
