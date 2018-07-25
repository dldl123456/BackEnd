package com.zhizuobiao.service.impl;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.dao.impl.UserDaoImpl;
import com.zhizuobiao.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean login(String username, String password) {
		User user = userDao.getUser(username);
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean regist(User user) {
		int code = userDao.insertUser(user);
		return code == 1 ? true : false;
	}

}
