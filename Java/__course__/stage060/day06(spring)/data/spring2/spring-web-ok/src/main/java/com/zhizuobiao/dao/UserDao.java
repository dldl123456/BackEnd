package com.zhizuobiao.dao;

import org.springframework.stereotype.Repository;

import com.zhizuobiao.bean.User;

@Repository
public class UserDao {

	public User getUser(int id) {
		User user = new User();
		user.setId(99);
		user.setName("test user");
		return user;
	}
}
