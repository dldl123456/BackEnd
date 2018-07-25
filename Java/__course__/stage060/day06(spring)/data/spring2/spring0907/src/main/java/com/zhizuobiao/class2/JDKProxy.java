package com.zhizuobiao.class2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
	private IUserDao userDao;

	public JDKProxy(IUserDao userDao) {

		this.userDao = userDao;
	}

	// �����������
	public IUserDao createProxy() {
		IUserDao proxy = (IUserDao) Proxy.newProxyInstance(
				// userDao�������
				userDao.getClass().getClassLoader(),
				// ʵ�ֵĽӿ�����
				userDao.getClass().getInterfaces(),
				// ����ص�����ʵ��
				this);
		return proxy;
	}

	// ����Ŀ�������κ�һ������ ���൱�ڵ���invoke();
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// if ("add".equals(method.getName())) {
		// ��¼��־:
		String methodName = method.getName();
		System.out.println("��־��¼=================" + methodName);
		// userDaoԭʼ���󣬲���
		Object result = method.invoke(userDao, args);
		return result;
		// }
		// return method.invoke(userDao, args);
	}
}