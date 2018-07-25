package com.zhizuobiao;

import java.util.Scanner;

import com.zhizuobiao.entity.User;
import com.zhizuobiao.service.UserService;
import com.zhizuobiao.service.impl.UserServiceImpl;

public class Run {
	static UserService userService = new UserServiceImpl();

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		while (true) {
			Scanner scan = new Scanner(System.in);
			// -------------------启动----------------------

			System.out.println("欢迎进入万达购票系统");
			System.out.println("1.用户登录");
			System.out.println("2.用户注册");
			System.out.println("3.后台登录");
			System.out.println("4.退出");

			int opt = scan.nextInt();
			switch (opt) {
			case 1:
				boolean result = login();

				if (!result) {
					continue;
				}

				index();
				break;
			case 2:
				// -------------------注册-----------------------
				System.out.println("请输入账号：");
				String username2 = scan.next();
				System.out.println("请输入密码：");
				String password2 = scan.next();
				System.out.println("请确定密码：");
				String repassword = scan.next();

				if (!password2.equals(repassword)) {
					System.out.println("两次密码不一致，重新注册！");
					continue;
				}

				System.out.println("请输入性别：");
				String sex = scan.next();
				System.out.println("请输入年龄：");
				int age = scan.nextInt();
				System.out.println("请输入手机号：");
				String mobile = scan.next();

				User user = new User();
				user.setAge(age);
				user.setAuth(1);
				user.setMobile(mobile);
				user.setSex(sex);
				user.setUsername(username2);
				user.setPassword(repassword);

				boolean success2 = userService.regist(user);
				if (success2) {
					System.out.println("注册成功！");
				} else {
					System.out.println("注册失败！");
				}

				break;
			case 3: // 管理员登录

				return;
			case 4:
				System.out.println("欢迎下次继续使用！");
				return;
			}

		}
	}

	@SuppressWarnings("resource")
	public static void index() {
		Scanner scan = new Scanner(System.in);
		// -------------------登录成功【首页】-----------------------
		System.out.println("1.购票");
		System.out.println("2.电影查询");
		System.out.println("3.充值");
		System.out.println("4.我的电影票【评论】");
		System.out.println("5.个人信息");
		System.out.println("6.退出");

		int opt = scan.nextInt();
		
		switch (opt) {
		case 1:
			
			break;

		default:
			break;
		}
	}

	@SuppressWarnings("resource")
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		// -------------------登录-----------------------
		System.out.println("请输入账号：");
		String username = scan.next();
		System.out.println("请输入密码：");
		String password = scan.next();

		boolean success = userService.login(username, password);
		return success;

	}
}
