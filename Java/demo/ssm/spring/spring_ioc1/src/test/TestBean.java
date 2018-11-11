package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Hello;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//实例化spring容器===相当于工厂类,实例化很多对象.并且管理这些对象.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//创建了一个对象
		Hello hw = (Hello) context.getBean("hw");
		System.out.println(hw);
		hw.sayHello();
	}
}
