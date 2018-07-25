package com.zhizuobiao.day3.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhizuobiao.day3.dao.UserDao;
import com.zhizuobiao.day3.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	public int insertUser(User user) {
		return 1;
	}

	public User getUser(int id) {
		User user = new User();
		user.setId(1);
		user.setName("class0907");
		return user;
	}

	public int deleteUser(int id) {
		return 11;
	}

	public int updateUser(User user) {
		return 111;
	}

}
