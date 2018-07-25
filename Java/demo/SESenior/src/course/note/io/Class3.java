package course.note.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * 字符流
 *
 */

public class Class3 {
	public static void main(String[] args) throws IOException {
		demo1();
	}
	
	// reader和writer
	public static void demo1() throws IOException{
		String path1 = "D://123//aa.txt",
			   path2 = "D://123//bb.txt";
			
			File file1 = new File(path1);
			File file2 = new File(path2);
			
			// char  byte
			//抽象类
			Reader fid = null;  //读
			Writer fiw = null;  //写
			
			fid = new FileReader(file1);
			fiw = new FileWriter(file2, true);  //是否追加
			//false表示，不管之前是什么内容，都重新开始写(清空再写)
			
			System.out.println("*********IO流操作代码基本相同********");
			
			char[] buff = new char[1024*1024];
			
			int len = 0;
			while((len=fid.read(buff))!=-1){
				// 创建一个字符串，获取字符数组的有效长度
				System.out.println(new String(buff, 0, len));
				fiw.write(buff, 0, len);
			}
			
			//测试flush方法
			fiw.write("测试flush方法");
			fiw.write("测试换行 \r\n abc");
			fiw.flush();  //不加在关闭之前也会刷新
			//刷新缓冲区，将缓冲区中的数据立即刷到目的文件中
			
			System.out.println("*********IO流操作代码基本相同********");
			
			fiw.close();
			fid.close();
	}
}
