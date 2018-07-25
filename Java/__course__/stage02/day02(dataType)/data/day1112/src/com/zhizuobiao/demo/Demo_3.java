package com.zhizuobiao.demo;

import java.util.Scanner;

public class Demo_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据用户提供的大写字母，显现相应的小写
		char c = 0;// 声明变量并赋初值
		System.out.println("请输入一个大写字母：");
		// 思考：怎么输入呢？Scanner（是一个类）
		// 1.new出实例对象
		Scanner input = new Scanner(System.in);// 准备工作
		// 2.调用对象使用它的方法
		c = input.next().charAt(0);// 用户输入的字母赋值给c
		// 计算机的计数是从0，比如火箭发射倒计时
		// input.close();// 一般不关
		c = (char) (c + 32);// 把大写字母转换成小写字母
		System.out.println("小写字母：" + c);
	}

}
