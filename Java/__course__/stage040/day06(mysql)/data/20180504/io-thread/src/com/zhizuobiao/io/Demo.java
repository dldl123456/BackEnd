package com.zhizuobiao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * io和file类
 */
public class Demo {

	public static void main(String[] args) {

	}

	public static void test1() throws IOException {
		File file = new File("d:/123/abd.txt");
		file.createNewFile();
		file.listFiles();
	}

	public static void test2() {
		// 字节流
		// 复制一个文件到其他位置

		File file = new File("xxx");

		FileInputStream fileIns = null;
		FileOutputStream fileOut = null;
		try {
			fileIns = new FileInputStream(file);

//			fileOut = new FileOutputStream(new File("xxxyyy"), true); // 是否追加
			fileOut = new FileOutputStream(new File("xxxyyy"));

			byte[] buff = new byte[1024];
			int len = 0;

			while ((len = fileIns.read(buff)) != -1) { // 读到buff数组
				// 保存
				fileOut.write(buff, 0, len); // 把buff数组中的内容，写出到磁盘上
			}

		} catch (IOException e) {

		} finally {
			// 关闭流
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileIns != null) {
				try {
					fileIns.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
