package com.zhizuobiao.class1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	
	@Test
	// Spring����
	public void demo1() {
		// ����һ��������.
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		// ���ݱ�ǩ��id��ȥspirng�����л�ȡclass
//		HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
//		System.out.println(hello);
//		hello = (HelloWorld) context.getBean("helloWorld");
//		System.out.println(hello);
//		hello.sayHello();
		
		// �ر�����
		((ClassPathXmlApplicationContext)context).close();
	} 
}
