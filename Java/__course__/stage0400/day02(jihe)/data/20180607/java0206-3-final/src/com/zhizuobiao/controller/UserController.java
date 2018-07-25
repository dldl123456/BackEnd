package com.zhizuobiao.controller;

import java.util.Scanner;

import com.zhizuobiao.bean.User;
import com.zhizuobiao.service.UserService;
import com.zhizuobiao.service.impl.UserServiceImpl;
import com.zhizuobiao.view.UserView;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserServiceImpl();
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int keyCode = 3;
		while (true) {
			UserView.indexView();
			try {
				keyCode = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("输入错误，请重新输入：");
				scanner = new Scanner(System.in);
			}
			switch (keyCode) {
			case 1:
				login();

				break;
			case 2:
				regist();
				break;
			case 3:
				System.out.println("谢谢使用！");
				return;
			}
		}
	}

	public void manager() {
		UserView.managerView();
	}

	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入账号：");
		String username = scanner.next();
		System.out.println("请输入密码：");
		String password = scanner.next();
		boolean success = userService.login(username, password);

		if (success) {
			System.out.println("进入信息系统：");
		} else {
			System.out.println("登录失败！");
		}
	}

	public void regist() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入账号：");
		String username = scanner.next();
		System.out.println("请输入密码：");
		String password = scanner.next();
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		;
		boolean success = userService.regist(user);

		if (success) {
			System.out.println("注册成功！");
		} else {
			System.out.println("注册失败！");
		}
	}
}
