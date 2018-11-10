package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Hello;

public class TestBean2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//spring实例化
		//实例化spring容器==相当于工厂类，实例化很多对象，并且管理了这些对象
		//因为所有的对象是放在配置文件中的，所以要加载配置文件
		/*
		 * 两种方法创建的容器 
		 */
		//默认的路径在src下（加载classpath下面配置文件）
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//以文件的方式加载（在工程下面的）默认的路径在工程下（加载磁盘下配置文件）
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
		
		
		//返回值是任意对象（Object）
		Hello hw = (Hello) context.getBean("hw");
		System.out.println(hw);
		
		Hello hw1 = (Hello) context.getBean("hw1");
		System.out.println(hw1);
		
		hw.sayHello();
		hw1.sayHello();
	}
}
