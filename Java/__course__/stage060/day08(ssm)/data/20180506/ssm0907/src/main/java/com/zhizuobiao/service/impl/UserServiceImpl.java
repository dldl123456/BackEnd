package com.zhizuobiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.entity.User;
import com.zhizuobiao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(int id) {
		return userDao.getUser(id);
	}

}
