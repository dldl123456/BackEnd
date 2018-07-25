/*
 * 从键盘输入自己的姓名和年龄并打印出来
 */

package test3;

import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		String name = null;  //定义名字
		int age = 0;  //定义年龄
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("请输入名字：");
		name = in.nextLine();
		
		System.out.print("请输入年龄：");
		age = in.nextInt();
		
		in.close();
		
		//输出名字和年龄
		System.out.println("名字：" + name + ", 年龄：" + age);
	}
}
