package com.zhizuobiao.day3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhizuobiao.day3.dao.UserDao;
import com.zhizuobiao.day3.entity.User;
import com.zhizuobiao.day3.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public int insertUser(User user) {
		System.out.println("参数：" + user);
		return userDao.insertUser(user);
	}

	public User getUser(int id) {
		System.out.println("参数：" + id);
		return userDao.getUser(id);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
}
