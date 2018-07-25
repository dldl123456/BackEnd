package com.zhizuobiao.class1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 缓冲流
 */
public class Demo2 {

	public static void main(String[] args) throws Exception {

		// 字节流 --> 字符流
		File file = new File("D:\\1_java\\a\\aaa.txt");
		FileInputStream fis = new FileInputStream(file);

		Reader reader = new InputStreamReader(fis, "utf-8");

		BufferedReader bufferedReader = new BufferedReader(reader);

		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		bis.read(new byte[1024]);
	}
}
