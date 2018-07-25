package com.zhizuobiao.day3.notification;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 代理工厂方式 通知类- 前置通知
 */
// -MethodBeforeAdvice-
// AfterReturningAdvice
// MethodInterceptor
// ThrowsAdvice
public class AopNotificationProxyFactoryBefore implements MethodBeforeAdvice {

	public void before(Method method, Object[] objects, Object o) throws Throwable {
		System.out.println("代理工厂前置通知");
	}
}
