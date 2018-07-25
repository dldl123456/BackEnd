package com.zhizuobiao.file;

import java.io.File;
import java.util.LinkedList;

/**
 * �ļ��б�����2�ַ�ʽ��
 */
public class Class3 {

	public static void main(String[] args) {

		File file = new File("D:\\1_java\\a");
		demo1(file);
		System.out.println("============================");
		demo2(file);
	}

	/**
	 * �ݹ����
	 */
	public static void demo2(File file) {
		File[] files = file.listFiles();
		// ����������
		if (files == null || files.length == 0) {
			// �ݹ鷵��
			return;
		}
		// ����files
		for (File f : files) {
			// �ж����ļ������ļ���
			if (f.isDirectory()) { // �ļ���
				// ���õݹ飬��������
				demo2(f);
			} else { // �ļ�
				// ��ӡ���
				System.out.println("�ļ�����" + f.getName());
			}
		}
	}

	/**
	 * �ǵݹ���÷�ʽ
	 */
	public static void demo1(File file) {

		LinkedList<File> fileList = new LinkedList<File>();

		// ��ȡ·���µ���������
		File[] files = file.listFiles();
		// ����
		for (File f : files) {
			// �ж����ļ������ļ���
			if (f.isDirectory()) { // �ļ���
				// ����������������ȷ������ʲô�����棨���飿���ϣ���
				fileList.add(f);
			} else { // �ļ�
				// ��ӡ���
				System.out.println("�ļ�����" + f.getName());
			}
		}
		// ��ǰ�ļ����µ�·�����ļ���������ɣ���
		// ������������������ļ������滹���ļ���

		// ���������е��ļ���
		while (!fileList.isEmpty()) { // �Ƿ񼯺�Ϊ��
			File tmpFile = fileList.removeFirst(); // ��ȡ���ϵ�һ��Ԫ�أ���ɾ��
			// ��ȡ�ļ����µ���������
			File[] tmpFiles = tmpFile.listFiles();
			// ����File[]
			for (File f : tmpFiles) {
				// �ж����ļ������ļ���
				if (f.isDirectory()) { // �ļ���
					// ����������������ȷ������ʲô�����棨���飿���ϣ���
					fileList.add(f);
				} else { // �ļ�
					// ��ӡ���
					System.out.println("�ļ�����" + f.getName());
				}
			}
		}
		
		
		// 1.�����Ƿ�Ϊ��
		// 2.�ڱ����Ĺ����У�����������ļ��У��������뼯��
		// �������б仯��
		// 3.removeFirst �Ƴ�һ�� �� add���һ���µ��ļ���
	}
}
