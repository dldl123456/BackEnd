package com.zhizuobiao.day3.notification;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注解 配置方式
 */

@Component
// 切面
@Aspect
public class AopNotificationAnno {

	// 定义切入点
	@Pointcut("execution(* com.zhizuobiao.day3.service.*.getUser(..))")
	public void pointcutA() { // 方法名：是切入点的名称
	}

	// 配置 通知（前置、后置...）+切入点=切面
	@After("pointcutA()") // testAfter->注入pointcutA切入点，@After后置通知
	public void testAfter() {
		System.out.println("测试后置通知");
	}
}
