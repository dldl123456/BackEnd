package com.zhizuobiao.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Work1 {
	// 1. ����һ��MP3�ļ�
	// Ҫ�󣺽�D�̸�Ŀ¼�µ�src.mp3�ļ����Ƶ�ͬһĿ¼�²�����Ϊdes.mp3

	public static void main(String[] args) {

		String name = "��׼����Ӱ��Ʊϵͳ����1.0.docx";
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
