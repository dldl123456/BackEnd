package course.demo.login;

import java.util.Scanner;

public class Login2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入密码：");
		
		//false循环跳出，true继续循环,所以要取反
		while(!in.next().equals("password")){
			System.out.println("登录失败，请重新输入：");
		}
		
		System.out.println("登录成功！");
		in.close();
	}
}
