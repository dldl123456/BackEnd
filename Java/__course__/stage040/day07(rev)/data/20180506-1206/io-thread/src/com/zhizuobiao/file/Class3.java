package com.zhizuobiao.file;

import java.io.File;
import java.util.LinkedList;

/**
 * 文件夹遍历（2种方式）
 */
public class Class3 {

	public static void main(String[] args) {

		File file = new File("D:\\1_java\\a");
		demo1(file);
		System.out.println("============================");
		demo2(file);
	}

	/**
	 * 递归调用
	 */
	public static void demo2(File file) {
		File[] files = file.listFiles();
		// 给结束条件
		if (files == null || files.length == 0) {
			// 递归返回
			return;
		}
		// 遍历files
		for (File f : files) {
			// 判断是文件还是文件夹
			if (f.isDirectory()) { // 文件夹
				// 调用递归，继续遍历
				demo2(f);
			} else { // 文件
				// 打印输出
				System.out.println("文件名：" + f.getName());
			}
		}
	}

	/**
	 * 非递归调用方式
	 */
	public static void demo1(File file) {

		LinkedList<File> fileList = new LinkedList<File>();

		// 获取路径下的所有内容
		File[] files = file.listFiles();
		// 遍历
		for (File f : files) {
			// 判断是文件还是文件夹
			if (f.isDirectory()) { // 文件夹
				// 保存起来，数量不确定？用什么来保存（数组？集合？）
				fileList.add(f);
			} else { // 文件
				// 打印输出
				System.out.println("文件名：" + f.getName());
			}
		}
		// 当前文件夹下的路径和文件，操作完成！！
		// 还有其他情况，就是文件夹里面还有文件夹

		// 遍历集合中的文件夹
		while (!fileList.isEmpty()) { // 是否集合为空
			File tmpFile = fileList.removeFirst(); // 获取集合第一个元素，并删除
			// 获取文件夹下的所有内容
			File[] tmpFiles = tmpFile.listFiles();
			// 遍历File[]
			for (File f : tmpFiles) {
				// 判断是文件还是文件夹
				if (f.isDirectory()) { // 文件夹
					// 保存起来，数量不确定？用什么来保存（数组？集合？）
					fileList.add(f);
				} else { // 文件
					// 打印输出
					System.out.println("文件名：" + f.getName());
				}
			}
		}
		
		
		// 1.集合是否为空
		// 2.在遍历的过程中，如果发现是文件夹，继续放入集合
		// 集合是有变化的
		// 3.removeFirst 移除一个 ， add添加一个新的文件夹
	}
}
