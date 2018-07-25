package com.zhizuobiao.file;

import java.io.File;
import java.sql.Date;

/**
 * java file类
 *
 */
public class Class1 {

	public static void main(String[] args) {
		// "D:\\1_java" 目录

		// /src/test.java
		String path = "D:" + File.separator + "1_java";

		String filePath = "D:" + File.separator + "1_java" + File.separator + "RSAUtil2.java";
		System.out.println(path);

		String testPath = "D:\\1_java\\test_io22";

		File file = new File(path);
		// .当前路径 ..上一级路径
		File file2 = new File("./Class.java");
		File file3 = new File(filePath);
		File file4 = new File(testPath); // 测试重命名

		// 不同的操作系统，分割符不一样 linux /

		// 常用file操作
		System.out.println(file.exists()); // true
		// 绝对路径
		System.out.println(file2.getAbsolutePath()); // D:\1_java
		// 相对路径
		System.out.println(file2.getPath());
		// 父路径
		System.out.println(file.getParent());
		// 获取名称
		System.out.println(file.getName());

		System.out.println(new Date(file.lastModified()));
		System.out.println(new Date(file3.lastModified()));

		// 获取文件大小 （文件夹除外）
		System.out.println(file.length());
		System.out.println(file3.length());

		// 重命名
		// System.out.println(file3.renameTo(new File("D:" + File.separator + "1_java" +
		// File.separator + "RSAUtil2.java")));
		// System.out.println(file4.renameTo(new File("D:\\1_java\\test_io22")));

		// 重命名+移动
		// System.out.println(file3.renameTo(new
		// File("D:\\1_java\\test_io22\\RSAUtil2.java")));

		// 删除文件，不是删除文件夹，空文件夹可以删除
		System.out.println(file4.delete());

		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				System.out.println("f-文件名：" + f.getName());
			} else {
				System.out.println("d-文件夹：" + f.getName());
			}
		}

		// 创建文件夹
		File dirFile = new File("D:\\1_java\\111\\22\\333\\444\\555");
		dirFile.mkdirs(); // 创建多级目录
		dirFile.mkdir(); // 创建一级目录，要保证父目录存在
		

		// 需求
		// 1.删除某文件夹下的所有文件
		// 2.列举某文夹下的所有文件

	}
}
