/*
 * 委托类
 * 真正执行任务的类，实现了代理接口 
 */

package dao;

import po.User;

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
