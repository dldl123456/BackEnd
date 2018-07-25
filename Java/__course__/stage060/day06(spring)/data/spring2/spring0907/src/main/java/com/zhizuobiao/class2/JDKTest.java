package com.zhizuobiao.class2;

import com.zhizuobiao.class1.UserDao;

public class JDKTest {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		// 生成代理需要实现接口
		JDKProxy jdkProxy = new JDKProxy(userDao);
		IUserDao proxy = jdkProxy.createProxy();

		System.out.println("原始对象：" + userDao);
		System.out.println("代理对象：" + proxy);

		System.out.println("userDao == userDao -> " + (userDao == userDao));
		System.out.println("proxy == userDao ->" + (proxy == userDao));

		proxy.getUser(1);

	}
}
