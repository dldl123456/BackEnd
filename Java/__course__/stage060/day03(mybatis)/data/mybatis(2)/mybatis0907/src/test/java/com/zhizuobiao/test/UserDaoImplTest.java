package com.zhizuobiao.test;

import org.junit.Before;
import org.junit.Test;

import com.zhizuobiao.dao.UserDao;
import com.zhizuobiao.dao.impl.UserDaoImpl;
import com.zhizuobiao.entity.User;

public class UserDaoImplTest {

	private UserDao userDao;

	@Before
	public void init() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testGetUser() {
		User user = userDao.getUser(12);
		System.out.println(user);
	}
}
