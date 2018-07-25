package video.note.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputoutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String str = "hello,shanghai";
		
		//字节输入流，从字节中读取数据
		//数据源是字节数组
		//字符串转字节数组
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
		
		int data = -1;
		
		while((data=bis.read())!=-1){
			System.out.print((char)data);
		}
		
		//无用
		bis.close();
		
		
		//字节数组输出流
		//默认32个长度的字节缓冲区
		ByteArrayOutputStream bos = new ByteArrayOutputStream(100);
		//给内部缓冲区写数据
		bos.write(97);
		//字符串转字节数组
		bos.write("helloh hh".getBytes());
		
		//返回一个字节数组
		byte[] buff = bos.toByteArray();
		
		for(byte data1:buff){
			System.out.print((char)data1);
		}
		
		FileOutputStream fos = new FileOutputStream("D:\\_site_\\aaa\\JavaList1.txt", true);
		//把ByteArrayOutputStream内部缓冲区的数据写到对呀的文件输出流中
		bos.writeTo(fos);
		
		//无用
		bos.close();
		
		//调用系统的资源
		fos.close();
	}
}
