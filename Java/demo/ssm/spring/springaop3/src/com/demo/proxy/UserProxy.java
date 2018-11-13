/*
 * AOP 
 */

package com.demo.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面（一个方法就是一个切片[程序片]）
 * aspect(切面)
 */
//实例化
@Component
@Aspect  //标记是一个切面
public class UserProxy {
	
	//配一个通知，之前
	//通知这个方法
	@Before("userAdd()")
	public void check(){
		System.out.println("检查权限");
	}
	
    /*
     * 定义pointcut切入点,名称useradd(),此方法是没有返回值和参数,
     * 该方法就是一个标识,不进行调用.
     */
	//加了一个注解就是标识
	//配一个切入点（写一个空方法,方法名随意）
	@Pointcut("execution(* com.demo.dao..*.*(..))")
	private void userAdd(){}

}
