package com.zhizuobiao.service.impl;

import java.sql.SQLException;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.dao.impl.UserDaoImpl;
import com.zhizuobiao.entity.User;
import com.zhizuobiao.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean regist(User user) {
		int code = 0;
		try {
			code = userDao.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code == 0 ? false : true;
	}

	@Override
	public boolean login(String username, String password) {
		User user = null;
		try {
			user = userDao.query(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user == null ? false : true;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

		public static void main(String[] args) {
			UserServiceImpl usi = new UserServiceImpl();
			System.out.println(usi.login("aa", "bb"));
		}
}
