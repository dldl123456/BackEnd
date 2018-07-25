package com.zhizuobiao.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Work1 {
	// 1. 复制一个MP3文件
	// 要求：将D盘根目录下的src.mp3文件复制到同一目录下并命名为des.mp3

	public static void main(String[] args) {

		String name = "标准化电影购票系统需求1.0.docx";
		File file = new File("C:\\Users\\cwx\\Desktop", name);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);

			fos = new FileOutputStream(new File("D:\\1_java\\a", "dy.docx"));

			byte[] buff = new byte[1024];

			int len = 0;

			while ((len = fis.read(buff)) != -1) {
				fos.write(buff, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
