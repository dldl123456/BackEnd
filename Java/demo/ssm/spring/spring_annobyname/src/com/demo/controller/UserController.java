/*
 *  控制层  调Service层
 *  servlet或者mvc
 *  
 */

package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.demo.bean.User;
import com.demo.service.UserService;

@Controller(value="userController")
public class UserController {
	private UserService userService;

	//注解按名称注入（和自动装配是等价的）
	@Autowired  //自动装配默认使用类型注入
	@Qualifier(value="userServiceImpl")  //按名称进行注入
	
	//set注入，用set方法
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//注册
	public void register(User user){
		System.out.println("controller");
		userService.addUser(user);
	}
}
