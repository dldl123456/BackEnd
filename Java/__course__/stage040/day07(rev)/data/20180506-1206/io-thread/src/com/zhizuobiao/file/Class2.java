package com.zhizuobiao.file;

/**
 * 递归
 */
public class Class2 {

	public static void main(String[] args) {
		test(10);
	}

	public static void test(int value) {
		System.out.println(value);
		if (value == 0) {
			return;
		} else {
			// --value 行
			// value-- 不行
			// 区别？
			test(--value);
		}
	}

}
