package com.zhizuobiao.class2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ֽ���
 *
 */
public class StreamDemo {

	public static void main(String[] args) throws Exception {
		// test3();
		// test4();
		test5();
	}

	// io��׼��д��
	public static void test5() {

		InputStream ins = null;
		OutputStream ous = null;
		try {
			ins = new FileInputStream(new File("C:\\Users\\cwx\\Desktop\\�����ƴ�ѧ��֤����-ְ����.pptx"));

			ous = new FileOutputStream(new File("D:\\1_java\\a\\java0206io.pptx"));
			// ins.read() һ���ֽ�һ���ֽڵĶ� �� �Ż�����
			byte[] buff = new byte[1024];

			int length = 0;
			// ins.read(buff) �ֽ�������������ݵĳ���
			while ((length = ins.read(buff)) != -1) { // �ļ������ж�
				ous.write(buff, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ���Ĺر�
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void test4() throws Exception {
		OutputStream ous = new FileOutputStream(new File("D:\\\\1_java\\\\a\\\\demo.txt"), true);
		ous.write(20013);
		ous.write(97);
		ous.write(98);
		ous.write('��');
	}

	public static void test3() throws Exception {

		InputStream ins = new FileInputStream(new File("C:\\Users\\cwx\\Desktop\\kk 2018-05-07 19-33-29.mp4"));
		// InputStream ins = new FileInputStream(new File("D:\\1_java\\a\\demo.txt"));

		// ins.read() һ���ֽ�һ���ֽڵĶ� �� �Ż�����
		byte[] buff = new byte[1024];

		int length = 0;
		// ins.read(buff) �ֽ�������������ݵĳ���
		while ((length = ins.read(buff)) != -1) { // �ļ������ж�
			System.out.println(length);
		}
	}

	public static void test2() throws Exception {

		InputStream ins = new FileInputStream(new File("C:\\Users\\cwx\\Desktop\\kk 2018-05-07 19-33-29.mp4"));
		// InputStream ins = new FileInputStream(new File("D:\\1_java\\a\\demo.txt"));

		int value = 0;
		while ((value = ins.read()) != -1) { // �ļ������ж�
			System.out.println(value);
		}
	}

	public static void test1() {
		InputStream ins = null; // new InputStream();

		try {
			// 0110 0001
			// 0100 1110 0010 1101
			// 97,20013
			// a��
			// 97 [0-255]{0000 0000 - 1111 1111} ascii
			// 11100100 10111000 10101101
			// 228
			// 184
			// 173
			ins = new FileInputStream(new File("D:\\1_java\\a\\demo.txt"));

			System.out.println(Integer.toBinaryString(97));
			System.out.println(Integer.toBinaryString(20013));

			int data1 = ins.read();
			int data2 = ins.read();
			int data3 = ins.read();
			int data4 = ins.read();
			int data5 = ins.read();
			int data6 = ins.read();
			int data7 = ins.read();
			int data8 = ins.read();
			int data9 = ins.read();

			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
			System.out.println(data4);
			System.out.println(data5);
			System.out.println(data6);
			System.out.println(data7);
			System.out.println(data8);
			System.out.println(data9);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�㴫���·����������ģ���");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
