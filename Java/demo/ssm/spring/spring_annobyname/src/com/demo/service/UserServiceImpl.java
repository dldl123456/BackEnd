package com.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserDao;

@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService {
	//传统方法
	//private UserDao userDaoImpl = new UserDaoImpl();
	
	private UserDao userDaoImpl;  //初始化
	
	//注解按名称注入（和自动装配是等价的）实例化userDaoImpl
	/*
	 * 按名字注入
	 */
	@Resource(name="userDaoImpl")
	
	//传统方法用new硬编码不可取，要用spring，set注入
	public void setUserDao(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public void addUser(User user) {
		System.out.println("service...");
		//实例化userDaoImpl之后才能调用方法
		userDaoImpl.addUser(user);
	}

}
