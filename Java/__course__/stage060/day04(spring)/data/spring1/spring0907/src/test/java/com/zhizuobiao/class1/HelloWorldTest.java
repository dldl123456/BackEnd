package com.zhizuobiao.class1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	
	@Test
	// Spring开发
	public void demo1() {
		// 创建一个工厂类.
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// 根据标签的id，去spirng容器中获取class
//		HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
//		System.out.println(hello);
//		hello = (HelloWorld) context.getBean("helloWorld");
//		System.out.println(hello);
//		hello.sayHello();
		
		// 关闭容器
		((ClassPathXmlApplicationContext)context).close();
	} 
}
