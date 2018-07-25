package video.note.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String name = "zzzz";
		int age = 10;
		boolean flag = true;
		char sex = '男';
		double money = 100.56;
		
		//过滤流，包装流
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\_site_\\aaa\\CCD.TXT"));
		
		//写入
		dos.writeUTF(name);
		dos.writeInt(age);
		dos.writeBoolean(flag);
		dos.writeChar(sex);
		dos.writeDouble(money);
		
		//关闭资源
		dos.close();
		
		//读取
		DataInputStream dis = new DataInputStream(new FileInputStream("D:\\_site_\\aaa\\CCD.TXT"));
		
		//读的顺序必须和写的顺序一致
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
		
		//关闭资源
		dis.close();
	}
}
