package com.zhizuobiao.file;

import java.io.File;
import java.sql.Date;

/**
 * java file��
 *
 */
public class Class1 {

	public static void main(String[] args) {
		// "D:\\1_java" Ŀ¼

		// /src/test.java
		String path = "D:" + File.separator + "1_java";

		String filePath = "D:" + File.separator + "1_java" + File.separator + "RSAUtil2.java";
		System.out.println(path);

		String testPath = "D:\\1_java\\test_io22";

		File file = new File(path);
		// .��ǰ·�� ..��һ��·��
		File file2 = new File("./Class.java");
		File file3 = new File(filePath);
		File file4 = new File(testPath); // ����������

		// ��ͬ�Ĳ���ϵͳ���ָ����һ�� linux /

		// ����file����
		System.out.println(file.exists()); // true
		// ����·��
		System.out.println(file2.getAbsolutePath()); // D:\1_java
		// ���·��
		System.out.println(file2.getPath());
		// ��·��
		System.out.println(file.getParent());
		// ��ȡ����
		System.out.println(file.getName());

		System.out.println(new Date(file.lastModified()));
		System.out.println(new Date(file3.lastModified()));

		// ��ȡ�ļ���С ���ļ��г��⣩
		System.out.println(file.length());
		System.out.println(file3.length());

		// ������
		// System.out.println(file3.renameTo(new File("D:" + File.separator + "1_java" +
		// File.separator + "RSAUtil2.java")));
		// System.out.println(file4.renameTo(new File("D:\\1_java\\test_io22")));

		// ������+�ƶ�
		// System.out.println(file3.renameTo(new
		// File("D:\\1_java\\test_io22\\RSAUtil2.java")));

		// ɾ���ļ�������ɾ���ļ��У����ļ��п���ɾ��
		System.out.println(file4.delete());

		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				System.out.println("f-�ļ�����" + f.getName());
			} else {
				System.out.println("d-�ļ��У�" + f.getName());
			}
		}

		// �����ļ���
		File dirFile = new File("D:\\1_java\\111\\22\\333\\444\\555");
		dirFile.mkdirs(); // �����༶Ŀ¼
		dirFile.mkdir(); // ����һ��Ŀ¼��Ҫ��֤��Ŀ¼����
		

		// ����
		// 1.ɾ��ĳ�ļ����µ������ļ�
		// 2.�о�ĳ�ļ��µ������ļ�

	}
}
