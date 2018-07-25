package com.zhizuobiao.class1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
	// private ApplicationContext context;
	private ClassPathXmlApplicationContext context;

	@Before
	public void init() {
		// 创建一个工厂类.
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void destory() {
		// 关闭容器
		((ClassPathXmlApplicationContext) context).close();
	}

	@Test
	// Spring开发
	public void demo1() {

		// 根据标签的id，去spirng容器中获取class
		HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
		System.out.println(hello);
		hello = (HelloWorld) context.getBean("helloWorld");
		System.out.println(hello);
		hello.sayHello();

	}

	@Test
	public void demo2() {

		User user = (User) context.getBean("user");
		System.out.println(user);

	}
	
	@Test
	public void demo3() {

		User user = (User) context.getBean("user2");
		System.out.println(user);

	}
	
	@Test
	public void demo4() {

		User user = (User) context.getBean("user3");
		System.out.println(user);

	}
	
	
	@Test
	public void demo5() {

		User user = (User) context.getBean("user4");
		System.out.println(user);

	}
	
	
	@Test
	public void demo6() {

		User user = (User) context.getBean("user5");
		System.out.println(user);

	}
	
	
	// 注释方式
	@Test
	public void demo7() {

		User user = (User) context.getBean("user9");
		System.out.println(user);

	}
}
