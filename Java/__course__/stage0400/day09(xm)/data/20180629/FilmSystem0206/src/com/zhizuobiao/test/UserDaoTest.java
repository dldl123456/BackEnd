package com.zhizuobiao.test;

import java.sql.SQLException;

import com.zhizuobiao.dao.impl.UserDaoImpl;
import com.zhizuobiao.entity.User;

/**
 * ≤‚ ‘¿‡
 */
public class UserDaoTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {

		UserDaoImpl userDao = new UserDaoImpl();

		User user = new User();
		// user.setAuth(2);
		// user.setAge(22);
		// user.setMobile("12306");
		// user.setPassword("123456");
		// user.setUsername("admin");
		// user.setSex("ƒ–");

		// userDao.insert(user);

		User user2 = userDao.query("admin", "123456");
		System.out.println(user2);
	}

}
