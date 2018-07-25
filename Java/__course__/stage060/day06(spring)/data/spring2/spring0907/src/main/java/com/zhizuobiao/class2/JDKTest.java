package com.zhizuobiao.class2;

import com.zhizuobiao.class1.UserDao;

public class JDKTest {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		// ���ɴ�����Ҫʵ�ֽӿ�
		JDKProxy jdkProxy = new JDKProxy(userDao);
		IUserDao proxy = jdkProxy.createProxy();

		System.out.println("ԭʼ����" + userDao);
		System.out.println("�������" + proxy);

		System.out.println("userDao == userDao -> " + (userDao == userDao));
		System.out.println("proxy == userDao ->" + (proxy == userDao));

		proxy.getUser(1);

	}
}
