package com.zhizuobiao.class2;

public class CglibTest {

	public static void main(String[] args) {
		String packageNameMath = "com.zhizuobiao";
		OrderDao orderDao = new OrderDao();

		if (packageNameMath.equals("com.zhizuobiao1")) {

			String value = orderDao.update("cglib 代理");
			orderDao.delete("张三");

		} else {

			CglibProxy proxy = new CglibProxy(orderDao);
			OrderDao orderProxy = proxy.getProxy();

			String value = orderProxy.update("cglib 代理");
//			orderProxy.delete("张三");
		}

	}
}
