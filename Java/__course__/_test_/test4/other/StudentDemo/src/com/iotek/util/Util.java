package com.iotek.util;

import java.util.Scanner;

/**
 * ������
 * @author Administrator
 *
 */
public class Util {
	
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * �ӿ���̨����һ������ ���ظ����÷� �����������ʹ�����κ�һ������
	 * 
	 * @param str
	 *            �û���ʾ��Ϣ
	 * @return �û��������Ϣ ,�ַ�������
	 */
	public static String getString(String str) {
		System.out.println(str);
		return scanner.next();

	}

	/**
	 * �ӿ���̨����һ������ ���ظ����÷� �����������ʹ�����κ�һ������
	 * 
	 * @param str
	 *            �û���ʾ��Ϣ
	 * @return �û��������Ϣ ����
	 */
	public  static int getInt(String str) {
		System.out.println(str);
		while (true) {
			try {
				int num = scanner.nextInt();// ���ܻ�����쳣����
				return num;
			} catch (Exception e) {
				System.out.println("����������!");
				scanner.nextLine();
			}
		}
		// return str;
	}

}
