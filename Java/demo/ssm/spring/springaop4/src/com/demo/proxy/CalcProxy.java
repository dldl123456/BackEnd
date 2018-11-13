package com.demo.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component  //实例化
@Aspect  //切面
public class CalcProxy {
	//前置通知（通知要有一个切入点，在哪里切入）
	@Before(value="calcMethod()")
	public void printLogBefore(){
		System.out.println("前置通知打印日志...");
	}
    
	//后置通知
	@After(value="calcMethod()")
	public void printLogAfter(){
		System.out.println("后置通知打印日志...");
	}
	
	//出现异常（有一个切入点，有一个异常对象）
	//出错了就会把异常对象打出来
	//异常通知
	@AfterThrowing(value="calcMethod()", throwing="ex")
	public void printLogAfterThrow(Exception ex){
		System.out.println("出现异常之后继续执行打印日志..." + ex.getMessage());
	}
	
	//返回通知
	//调用方法之后，把值返回来（有返回值的方法）
	@AfterReturning(value="calcMethod()", returning="retValue")
	public void printLogAfterReturn(Object retValue){
		System.out.println("返回通知打印日志..." + retValue);
	}
	
	//环绕通知（在方法之前要通知，在方法之后也要通知，要返回结果）
	//把处理的结果返回
	@Around(value="calcMethod()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("之前....");
		
		Object retValue = pjp.proceed();
		
		System.out.println("环绕通知打印日志..." + retValue);
		System.out.println("之后....");
		
		return retValue;
	}
	
	//切入点
	@Pointcut("execution(* com.demo.bean..*.*(..))")
	public void calcMethod(){};
}
