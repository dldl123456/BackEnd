package com.zhizuobiao.homework;

import java.io.File;

public class Work2 {

	// ���һ���ļ����е��������ݣ�ʹ��File�͵ݹ麯����ʵ��
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
				System.out.println("�ļ��У�" + currentFile.getAbsolutePath());
				// �ݹ����
				deleteDir(currentFile.getAbsolutePath());
			}
			// ɾ���ļ�
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
				System.out.println("�ļ��У�" + currentFile.getAbsolutePath());
				// �ݹ����
				printContent(currentFile.getAbsolutePath());
			} else {
				System.out.println("�ļ���" + currentFile.getAbsolutePath());
			}
		}
	}
}
