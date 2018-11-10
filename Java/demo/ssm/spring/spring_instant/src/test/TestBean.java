package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import bean.Hello;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
		
		Hello hw = (Hello) context.getBean("hw");
		hw.sayHello();
	}
}
