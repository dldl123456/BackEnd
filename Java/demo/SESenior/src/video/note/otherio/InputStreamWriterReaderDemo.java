package video.note.otherio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamWriterReaderDemo {
	public static void main(String[] args) throws IOException{
		//写入
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\_site_\\aaa\\io1.txt"), "utf-8");
		
		//包装，加缓冲区
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("你好");
		
		bw.close();
		
		//读(gb2312.编码不对)
		//BufferedReader br = new BufferedReader(new FileReader("D:\\_site_\\aaa\\io1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\_site_\\aaa\\io1.txt"), "utf-8"));
		
		String line = null;
		
		//一行行读，读取一行，赋值给字符串变量
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}
}