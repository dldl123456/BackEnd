package com.zhizuobiao.service.impl;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.entity.User;
import com.zhizuobiao.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public boolean checkLogin(User user) {
		return false;
	}

	@Override
	public boolean registUser(User user) {
		int code = userDao.insertUser(user);
		return false;
	}

}
