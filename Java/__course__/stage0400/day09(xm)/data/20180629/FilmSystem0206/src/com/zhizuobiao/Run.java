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
			// -------------------����----------------------

			System.out.println("��ӭ������ﹺƱϵͳ");
			System.out.println("1.�û���¼");
			System.out.println("2.�û�ע��");
			System.out.println("3.��̨��¼");
			System.out.println("4.�˳�");

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
				// -------------------ע��-----------------------
				System.out.println("�������˺ţ�");
				String username2 = scan.next();
				System.out.println("���������룺");
				String password2 = scan.next();
				System.out.println("��ȷ�����룺");
				String repassword = scan.next();

				if (!password2.equals(repassword)) {
					System.out.println("�������벻һ�£�����ע�ᣡ");
					continue;
				}

				System.out.println("�������Ա�");
				String sex = scan.next();
				System.out.println("���������䣺");
				int age = scan.nextInt();
				System.out.println("�������ֻ��ţ�");
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
					System.out.println("ע��ɹ���");
				} else {
					System.out.println("ע��ʧ�ܣ�");
				}

				break;
			case 3: // ����Ա��¼

				return;
			case 4:
				System.out.println("��ӭ�´μ���ʹ�ã�");
				return;
			}

		}
	}

	@SuppressWarnings("resource")
	public static void index() {
		Scanner scan = new Scanner(System.in);
		// -------------------��¼�ɹ�����ҳ��-----------------------
		System.out.println("1.��Ʊ");
		System.out.println("2.��Ӱ��ѯ");
		System.out.println("3.��ֵ");
		System.out.println("4.�ҵĵ�ӰƱ�����ۡ�");
		System.out.println("5.������Ϣ");
		System.out.println("6.�˳�");

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
		// -------------------��¼-----------------------
		System.out.println("�������˺ţ�");
		String username = scan.next();
		System.out.println("���������룺");
		String password = scan.next();

		boolean success = userService.login(username, password);
		return success;

	}
}
