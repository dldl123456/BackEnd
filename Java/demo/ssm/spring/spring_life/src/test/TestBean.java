package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Hello;

public class TestBean {
	public static void main(String[] args) {
		//实例化spring容器===相当于工厂类,实例化很多对象.并且管理这些对象.
		//销毁必须用抽象类AbstractApplicationContext,抽象类不能实例化
		//ClassPathXmlApplicationContext默认路径在src下
		//接口没有close方法，只有抽象类有close方法
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//bean的生命周期，单例
		Hello hw1 = (Hello) context.getBean("hw");
		System.out.println(hw1);
		hw1.sayHello();
		
		//销毁有一个方法，必须把实例化出来的spring容器关闭
		//不关闭一直存在
		context.close();
		
		//容器关闭之后，对象自动销毁，所以拿不到对象了
		Hello hw2 = (Hello) context.getBean("hw");
		System.out.println(hw2);
		hw2.sayHello();
	}
}
