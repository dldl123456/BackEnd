package com.zhizuobiao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ֽ���
 */
public class Class4 {

	public static void main(String[] args) throws IOException {

		File file = new File("D:\\1_java\\123.txt");
		File file2 = new File("D:\\1_java\\123-321.txt");
		// ��ȡfile�ļ�
		InputStream ins = new FileInputStream(file);

		OutputStream fileOus = new FileOutputStream(file2);
		
		// ���ֽ���
		// byte -- 8λ [00000000 - 11111111] [0 - 255]
		// int value = ins.read(); //
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());

		int content = 0;
		byte[] buff = new byte[1024];
		// while ((content = ins.read()) != -1) {
		// // �ļ�û�ж���
		// System.out.println("=" + content);
		// }
		int len = 0;
		while ((len = ins.read(buff)) != -1) {
			// [97,98,99,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X..1024]
			System.out.println(len);
			// 1.�ֽ�����
			// ��2�����������������ݵ���Ч����
			fileOus.write(buff, 0, len);
		}
		// �ر� �����淶
		fileOus.close();
		ins.close();
	}

}
