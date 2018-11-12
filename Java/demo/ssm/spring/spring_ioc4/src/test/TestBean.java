package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Bean;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//实例化spring容器===相当于工厂类,实例化很多对象.并且管理这些对象.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//加载bean对象
		Bean bean = (Bean) context.getBean("bean");
		
		//bean
		System.out.println(bean.getId() + bean.getName());
		
		//通过bean访问bean1的属性
		System.out.println(bean.getBean1().getName());
		
		//加载b1对象
		Bean b1 = (Bean) context.getBean("b1");
		System.out.println(b1.getId() + b1.getName());
		System.out.println(b1.getBean1().getName());
		
	}
}
