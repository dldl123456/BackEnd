/*
 * 委托类
 * 真正执行任务的类，实现了代理接口 
 */

package com.demo.dao;

import org.springframework.stereotype.Component;

import com.demo.po.User;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		System.out.println("add User..-.");
	}
	
	@Override
	public void deleteUser(User user) {
		System.out.println("delete User.-..");
	}
	
}
