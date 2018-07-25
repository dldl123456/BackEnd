package com.zhizuobiao.class2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

	// 被代理对象
	private OrderDao orderDao;

	public CglibProxy(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	// 返回代理对象（Target【目标对象】）
	public OrderDao getProxy() {
		Enhancer enhancer = new Enhancer();

		// 设置代理类的class
		enhancer.setSuperclass(orderDao.getClass());

		// 设置回调
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

				System.out.println("前置通知：增强代码位置");

				Object value = null;
				try {
					// 原始对象调用方法
					value = method.invoke(orderDao, args);
				} catch (Exception e) {
					System.out.println("异常通知");
				} finally {
					System.out.println("最终通知");
				}

				System.out.println("后置通知：增强代码位置");

				return value;
			}
		});

		// 返回proxy对象
		return (OrderDao) enhancer.create();
	}
}
