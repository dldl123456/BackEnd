package com.zhizuobiao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流
 */
public class Class4 {

	public static void main(String[] args) throws IOException {

		File file = new File("D:\\1_java\\123.txt");
		File file2 = new File("D:\\1_java\\123-321.txt");
		// 读取file文件
		InputStream ins = new FileInputStream(file);

		OutputStream fileOus = new FileOutputStream(file2);
		
		// 读字节流
		// byte -- 8位 [00000000 - 11111111] [0 - 255]
		// int value = ins.read(); //
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());
		// System.out.println(ins.read());

		int content = 0;
		byte[] buff = new byte[1024];
		// while ((content = ins.read()) != -1) {
		// // 文件没有读完
		// System.out.println("=" + content);
		// }
		int len = 0;
		while ((len = ins.read(buff)) != -1) {
			// [97,98,99,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X..1024]
			System.out.println(len);
			// 1.字节数组
			// 后2个参数：数组中数据的有效长度
			fileOus.write(buff, 0, len);
		}
		// 关闭 并不规范
		fileOus.close();
		ins.close();
	}

}
