package com.zhizuobiao.dao.impl;

import java.util.ArrayList;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.dao.UserDao;

/**
 * ���ϱ�������
 *
 */
public class UserDaoImpl implements UserDao {

	private ArrayList<User> list;

	public UserDaoImpl() {
		list = new ArrayList<User>();
	}

	@Override
	public int insertUser(User user) {
		boolean success = list.add(user);
		return success ? 1 : 0;
	}

	@Override
	public User getUser(String username) {
		for (User user : list) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

}
