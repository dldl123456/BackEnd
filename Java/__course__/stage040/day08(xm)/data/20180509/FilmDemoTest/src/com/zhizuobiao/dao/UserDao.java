package com.zhizuobiao.dao;

import com.zhizuobiao.entity.User;

public interface UserDao {

	int insertUser(User user);

	User getUser(int id);
}
