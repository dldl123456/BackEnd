package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import po.User;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//加载spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserDao userDaoImpl = (UserDao)context.getBean("userProxy");
		
		userDaoImpl.addUser(new User());
	}
}
