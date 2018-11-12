package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.User;
import com.demo.controller.UserController;
import com.demo.dao.UserDao;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

public class TestBean {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//传统方法
		/*UserService userService = new UserServiceImpl();
		
		User user = new User();
		userService.addUser(user);*/
		
		//用spring注入
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//userDao中被实例化，通过@Component注解
		UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
		
		User user = new User();
		
		//实例化
		userDaoImpl.addUser(user);
		
		//判断userServiceImpl有没被注入
		UserService userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
		userServiceImpl.addUser(user);
		
		//判断userController有没被注入
		UserController userController = (UserController) context.getBean("userController");
		userController.register(user);
	}
}
