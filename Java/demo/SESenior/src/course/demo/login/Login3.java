package course.demo.login;

import java.util.Scanner;

public class Login3 {
	public static void main(String[] args) {
		int op = 0;  //选项
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		
		do{
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("0.退出");
			System.out.println("请输入选项：");
			op = in.nextInt();
			
			switch (op) {
				case 1:
					System.out.println("登录");
					break;
				case 2:
					System.out.println("注册");
					break;
				case 0:
					System.out.println("欢迎使用，下次再来！");
					flag = false;
					break;
				default:
					System.out.println("输入有误，重新选择！");
					break;
			}
		}while(flag);
		
		in.close();
	}
}
