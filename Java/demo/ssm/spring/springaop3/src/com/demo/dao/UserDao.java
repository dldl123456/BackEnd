/*
 * 静态代理
 * 代理接口，处理的任务(委托被代理类(委托类))
 */

package com.demo.dao;

import com.demo.po.User;

public interface UserDao {
	public void addUser(User user);
	
	public void deleteUser(User user);
}
