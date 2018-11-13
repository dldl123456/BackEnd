package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Calc;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Calc calc = (Calc)context.getBean("calc");
		
		calc.mul(10, 20);
		
		//calc.div(10, 0);  //除数不能为0，会出现异常
		//出现异常会通知
		
		//调用方法之后，把值返回来（有返回值的方法）
		//返回结果，返回通知拿到值
		
		//环绕通知，做除法之前做了什么，之后做了什么
		//把处理的结果返回
		calc.div(10, 2);
	}

}
