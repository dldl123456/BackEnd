package course.note.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
	1.Java的字节流
	   InputStream是所有字节输入流的祖先，而OutputStream是所有字节输出流的祖先。
	2.Java的字符流
	   Reader是所有读取字符串输入流的祖先，而writer是所有输出字符串的祖先。
	InputStream，OutputStream,Reader,writer都是抽象类。所以不能直接new 
 */

/**
 * 字节流(所有情况都可以用，文字优先用字符流)
 */

public class Class1 {
	public static void main(String[] args) throws IOException {
		File file1 = new File("D:\\1_java\\aa.txt");
		File file2 = new File("D:\\1_java\\bb.txt");
		//InputStream是抽象类，用他的子类做实例化
		//读取file文件
		InputStream ins = new FileInputStream(file1);
		
		//输出流
		OutputStream ous = new FileOutputStream(file2);
		// 读取字节流
		// byte -- 8位[00000000-11111111][0-255]
//		int value = ins.read();  //返回一个长度
		
		//没有字符返回-1
		/*System.out.println(ins.read());
		System.out.println(ins.read());
		System.out.println(ins.read());
		System.out.println(ins.read());*/
		//int content = 0;
		//一位一位地读文字,效率低，所以用数组
		//一次读1024个字节
		byte[] buff = new byte[1024];
		
		/*while((content = ins.read()) != -1){
			//文件未读完
			System.out.println("=" + content);
		}*/
		
		int len = 0;
		while((len = ins.read(buff)) != -1){
			//[97，,9,99，x,x,…1024]
			System.out.println(len);
			//字节数组，数组中数据的有效长度
			ous.write(buff, 0, len);
		}
		
		//流必须要关闭,并不规范
		ins.close();
		ous.close();
	}
}
