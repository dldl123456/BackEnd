package com.iotek.util;

import java.util.Scanner;

/**
 * 工具类
 * @author Administrator
 *
 */
public class Util {
	
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 从控制台输入一个数据 返回给调用方 这个方法可以使用与任何一个需求
	 * 
	 * @param str
	 *            用户提示信息
	 * @return 用户输入的信息 ,字符串类型
	 */
	public static String getString(String str) {
		System.out.println(str);
		return scanner.next();

	}

	/**
	 * 从控制台输入一个数据 返回给调用方 这个方法可以使用与任何一个需求
	 * 
	 * @param str
	 *            用户提示信息
	 * @return 用户输入的信息 整形
	 */
	public  static int getInt(String str) {
		System.out.println(str);
		while (true) {
			try {
				int num = scanner.nextInt();// 可能会造成异常现在
				return num;
			} catch (Exception e) {
				System.out.println("请输入整形!");
				scanner.nextLine();
			}
		}
		// return str;
	}

}
