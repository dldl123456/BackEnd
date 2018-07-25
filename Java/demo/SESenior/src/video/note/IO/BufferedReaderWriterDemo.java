/*
 * 读取文件
 */

package video.note.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:\\_site_\\aaa\\JavaList.txt");
		FileWriter fw = new FileWriter("D:\\_site_\\aaa\\JavaLis3t.txt");
		
		//设置包装类手动设置字符缓冲区
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line = null;
		
		while((line=br.readLine())!=null){
			System.out.println(line);
			bw.write(line);
			bw.newLine();  //换行
			//bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
