package com.zhizuobiao.class2;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class LogInfo {

	public void before() {
		System.out.println("LogInfo 方法前调用");
	}

	public void after() {
		System.out.println("LogInfo 方法后调用");
	}

	public void throwing(Throwable e) {
		System.out.println("LogInfo 异常通知");
	}

	public Object around(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			System.out.println("LogInfo 环绕通知 前");
			result.toString();
			result = pjp.proceed();
			System.out.println("LogInfo 环绕通知 后");
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			System.out.println("LogInfo 环绕通知 catch");
		} finally {
			System.out.println("LogInfo 环绕通知 finally");
		}
		return result;
	}

	public void returning(Object value) {
		System.out.println("LogInfo 返回通知:" + value);
	}
}
