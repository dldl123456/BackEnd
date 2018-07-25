package com.zhizuobiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.dao.UserDao;

@Controller
public class RestfullContrller {

	@Autowired
	private UserDao userDao;
	
	
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") int id) {

		User user = userDao.getUser(id);
//		User user = new User();
//		user.setId(id);
		return user;
	}
}
