package com.zhizuobiao.dao;

import com.zhizuobiao.bean.User;

public interface UserDao {

	int insertUser(User user);

	User getUser(String username);
}
