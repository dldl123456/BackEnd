package com.zhizuobiao.class2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ×Ö·ûÁ÷
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception {

		test1();
	}

	public static void test2() throws Exception {
		FileWriter writer = new FileWriter(new File("D:\\1_java\\a\\demo.txt"));

		writer.write("abcÄãºÃ");
		
		writer.close();
	}

	public static void test1() throws Exception {
		FileReader reader = new FileReader(new File("D:\\1_java\\a\\demo.txt"));
		int value = 0;
		while ((value = reader.read()) != -1) {
			System.out.println((char) value);
		}
		reader.close();
	}
}
