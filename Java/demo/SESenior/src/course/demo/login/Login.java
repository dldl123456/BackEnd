package course.demo.login;

import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		String pwd = null;
		boolean flag = true;  //跳出循环的条件
		Scanner in = new Scanner(System.in);
		
		while(flag){
			System.out.println("请输入密码：");
			pwd = in.next();
			
			if(pwd.equals("password")){
				System.out.println("登录成功！");
				flag = false;
			}else{
				System.out.println("登录失败！");
			}
		}
		
		in.close();
	}
}
