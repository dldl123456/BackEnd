package com.zhizuobiao.homework;

import java.io.File;

public class Work2 {

	// 输出一个文件夹中的所有内容，使用File和递归函数来实现
	public static void main(String[] args) {

		// printContent("D:\\1_java\\a");
		// File file = new File("D:\\1_java\\a");
		// System.out.println(file.delete());

		deleteDir("D:\\1_java\\a");
	}

	public static void deleteDir(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		if (files == null) {
			return;
		}
		for (File currentFile : files) {
			if (currentFile.isDirectory()) {
				System.out.println("文件夹：" + currentFile.getAbsolutePath());
				// 递归调用
				deleteDir(currentFile.getAbsolutePath());
			}
			// 删除文件
			currentFile.delete();
		}
	}

	public static void printContent(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		if (files == null) {
			return;
		}
		for (File currentFile : files) {
			if (currentFile.isDirectory()) {
				System.out.println("文件夹：" + currentFile.getAbsolutePath());
				// 递归调用
				printContent(currentFile.getAbsolutePath());
			} else {
				System.out.println("文件：" + currentFile.getAbsolutePath());
			}
		}
	}
}
