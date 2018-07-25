package com.zhizuobiao.test;

public class Test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输出1-100之间所有数，跳过3的倍数和带3的数
		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0 || i % 10 == 3 || i / 10 == 3) {
				continue;// 跳过此次循环，继续下一次的循环
			}
			System.out.println(i);
		}
	}

}
