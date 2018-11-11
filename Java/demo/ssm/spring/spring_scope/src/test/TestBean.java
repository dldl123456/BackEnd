package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bean.Hello;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
		
		//两个对象地址一样（说明作用域默认是单例）
		//两个对象地址不一样说明scope是多例prototype
		Hello hw1 = (Hello) context.getBean("hw");
		System.out.println(hw1);
		hw1.sayHello();
		
		Hello hw2 = (Hello) context.getBean("hw");
		System.out.println(hw2);
		hw2.sayHello();
	}
}
