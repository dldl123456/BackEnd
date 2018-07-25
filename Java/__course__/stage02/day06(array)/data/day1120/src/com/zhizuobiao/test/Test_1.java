package com.zhizuobiao.test;

import java.util.Scanner;

public class Test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int num = 0;// 用户给定
		int index = -1;// 记录下标
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要删除的数字：");
		num = input.nextInt();
		// 1.查有没有
		for (int i = 0; i < arr2.length; i++) {
			if (num == arr2[i]) {
				index = i;// 记录存在的下标
				break;
			}
		}
		if (index == -1) {
			System.out.println("没有这个数据，无序删除！");
			return;
		}
		arr2[index] = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 0) {
				continue;
			}
			System.out.println(arr2[i]);
		}
	}

}
