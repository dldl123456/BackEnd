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
		
		//设置Bean1的name值
		bean.getBean1().setName("子啊");
		System.out.println(bean.getBean1().getName());
	}
}
