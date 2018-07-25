package com.zhizuobiao.class1;

import java.io.File;

/**
 * file��
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		test5();
	}

	public static void test5() {
		File file = new File("D:" + File.separator + "1_java\\a\\aa\\aaa");

		file.renameTo(new File("D:" + File.separator + "1_java\\a\\aa\\ddd"));
	}

	public static void test4() {
		File file = new File("");

		System.out.println("getAbsolutePath = " + file.getAbsolutePath());
		System.out.println("getPath = " + file.getPath());

	}

	public static void test3() {
		File file = new File("D:" + File.separator + "1_java\\a\\aa\\aaa\\aaaa");

		file.delete();

	}

	public static void test2() {
		File file = new File("D:\\1_java\\a\\aa\\aaa\\aaaa");
		// file.mkdir(); // ֻ�ܴ���һ��Ŀ¼
		file.mkdirs(); // ֻ�ܴ����༶Ŀ¼

	}

	public static void test1() {
		File file = new File("C:\\Users\\cwx\\Desktop\\�̰�");

		File[] files = file.listFiles();

		for (File f : files) {
			System.out.println(f.getName());
		}

	}
}
