package com.zhizuobiao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流
 */
public class Class2 {

	public static void main(String[] args) throws Exception {

		// demo1();

		demo2();
	}

	/**
	 * 自学内容
	 */
	public static void demo3() throws Exception {
		// 1.缓冲流（字节，字符）--> 大文件读取，提高效率
		// 2.缓冲流
		// 3.读取（磁盘，网络）{从网络中读取，写到磁盘上（下载）}
		// 4.Properties 配置文件的操作
		// 5.PrintStream servlet（javaee）中有出现
		// 6.RandomAccessFile --> File扩展 （文件切割和合并）
		// 7.Serializable --> 对象的序列化（java内存中的对象，保存到本地磁盘上）
		// 8.内存 --> ByteArrayInputStream，ByteArrayOutputStream
		
	}

	// 转换流
	public static void demo2() throws Exception {
		// 字节流 - 字符流
		FileInputStream fileIns = new FileInputStream(new File("/Users/chengweixin/test_eg/hello.txt"));
		FileOutputStream fileOus = new FileOutputStream(new File("/Users/chengweixin/test_eg/hello2.txt"));

		// 读 编码 （乱码）解决--> 文件编码就是你设置读取的编码
		// 写 编码 需求决定

		// 可以指定编码格式：eg（utf8，gbk，unicode，iso8859-1）
		Reader fileReader = new InputStreamReader(fileIns, "utf-8"); // 字符编码
		// Reader fileReader = new InputStreamReader(fileIns); // 输入字节流 --> 输入字符流
		Writer fileWriter = new OutputStreamWriter(fileOus, "iso-8859-1");// 输出字节流 --> 输出字符流

		char[] buff = new char[1024];
		int len = 0;
		while ((len = fileReader.read(buff)) != -1) {
			fileWriter.write(buff, 0, len);
		}

		fileWriter.close();
		fileReader.close();

	}

	public static void demo1() throws Exception {
		// char byte
		Reader reader = null; // 读
		Writer writer = null; // 写

		FileReader fileReader = new FileReader(//
				new File("/Users/chengweixin/test_eg/hello.txt"));

		FileWriter fileWriter = new FileWriter(//
				new File("/Users/chengweixin/test_eg/hello2.txt"), false); // boolean 是否追加

		System.out.println("=========io流操作代码基本相同=========");
		char[] buff = new char[1024];
		int len = 0;
		while ((len = fileReader.read(buff)) != -1) {
			System.out.println(new String(buff, 0, len));
			fileWriter.write(buff, 0, len);
		}

		fileWriter.write("测试flash方法");
		fileWriter.write("测试换行 \r\n abc"); // \r\n 换行
		fileWriter.flush(); // 刷新缓冲区，将缓冲区中的数据刷到目的地文件中。

		System.out.println("=========io流操作代码基本相同=========");
		fileWriter.close();
		fileReader.close();

	}
}
