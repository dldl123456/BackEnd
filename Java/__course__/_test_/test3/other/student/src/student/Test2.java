package student;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		boolean b=false;
		do {
			System.out.println("************主菜单功能***************");
			System.out.println("1.查看学生信息");
			System.out.println("2.添加学员信息");
			System.out.println("3.修改学员信息( 温馨提示：修改年龄和地址哦)");
			System.out.println("4.删除学员信息");
			System.out.println("5.返回");
			System.out.println("************************************");
			System.out.println("请选择");
			Scanner scanner=new Scanner(System.in);
			boolean isTrue=scanner.hasNext();
			while (!isTrue) {//不是字符进入
				int str =  scanner.nextInt();
				System.out.println("您输入的是:"+str+"  只能输入字符哦！");
				System.out.println("请重新输入：");
				isTrue=scanner.hasNext();
				
			}
			int a=scanner.nextInt();
			switch (a) {
			case 1:
				b=true;
				System.out.println("1.查看学生信息");
				break;
			case 2:
				b=true;
				System.out.println("2.添加学员信息");
				break;
			case 3:
				b=true;
				System.out.println("3.修改学员信息( 温馨提示：修改年龄和地址哦)");
				break;
			case 4:
				b=true;
				System.out.println("4.删除学员信息");
				break;
			case 5:
				b=false;
				System.out.println("5.返回");
				break;
			}
		} while (b);
		System.out.println("1111");
		
	}
}
