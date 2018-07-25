package com.zhizuobiao.demo;

public class Demo_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				// break;//跳出当前循环
				// continue;//跳过此次循环继续下次循环
				return;//跳出方法
			}
			System.out.println(i);
		}
		System.out.println("哈哈");
	}

}
