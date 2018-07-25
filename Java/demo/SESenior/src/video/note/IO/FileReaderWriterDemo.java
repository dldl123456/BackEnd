package video.note.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	public static void main(String[] args) throws IOException {
		//字符输入流
		FileReader fr = new FileReader("D:\\_site_\\aaa\\JavaList.txt");
		//字符输出流
		FileWriter fw = new FileWriter("D:\\_site_\\aac\\Java879.txt");
		
		//读到缓冲区(字符数组)
		char[] buff = new char[100];
		
		int len = 0;  //实际读到的字符个数
		
		//读到末尾
		while((len=fr.read(buff))!=-1){
			//复制
			fw.write(buff, 0, len);
			fw.flush();  //强制清空缓冲区，把缓冲区中的数据强制写到输出流
		}
		
		//释放资源
		fr.close();
		fw.close();  //不关闭无法复制，缓冲区没放满，也会调用flush
	}
}
