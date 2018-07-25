package com.zhizuobiao.demo;

import java.util.Scanner;

public class Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入自己的姓名，性别，年龄和想获得的成绩，然后在控制台显示
		String name = null;// 姓名
		char sex = 0;// 性别
		int age = 0;// 年龄
		double score = 0.0;// 成绩
		Scanner input=new Scanner(System.in);
		System.out.println("请输入自己的姓名，性别，年龄和成绩：");
		name=input.next();
		sex=input.next().charAt(0);
		age=input.nextInt();
		score=input.nextDouble();
		System.out.println("名字："+name+"\n年龄："+age+"\n性别："+sex+"\n成绩："+score);
	}

}
