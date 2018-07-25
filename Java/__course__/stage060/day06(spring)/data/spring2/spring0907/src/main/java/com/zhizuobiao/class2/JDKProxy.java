package com.zhizuobiao.class2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
	private IUserDao userDao;

	public JDKProxy(IUserDao userDao) {

		this.userDao = userDao;
	}

	// 创建代理对象
	public IUserDao createProxy() {
		IUserDao proxy = (IUserDao) Proxy.newProxyInstance(
				// userDao类加载器
				userDao.getClass().getClassLoader(),
				// 实现的接口数组
				userDao.getClass().getInterfaces(),
				// 代理回调方法实现
				this);
		return proxy;
	}

	// 调用目标对象的任何一个方法 都相当于调用invoke();
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// if ("add".equals(method.getName())) {
		// 记录日志:
		String methodName = method.getName();
		System.out.println("日志记录=================" + methodName);
		// userDao原始对象，参数
		Object result = method.invoke(userDao, args);
		return result;
		// }
		// return method.invoke(userDao, args);
	}
}