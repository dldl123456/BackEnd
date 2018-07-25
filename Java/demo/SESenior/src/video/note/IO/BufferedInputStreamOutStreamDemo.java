package video.note.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamOutStreamDemo {
	public static void main(String[] args) {
		try {
			FileUtil.copy(new File("D:/_site_/aaa/JavaList.txt"), new File("D:/_site_/aab/JavaList1.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class FileUtil{
	public static void copy(File src, File dst) throws IOException{
		//创建文件输入流（读取文件中的内容）
		FileInputStream fis = new FileInputStream(src);
		//创建文件输出流（写出文件中的内容）
		FileOutputStream fos = new FileOutputStream(dst);
		
		//包装类
		//构造方法接收字节输入流，增加缓冲区的功能
		BufferedInputStream bis = new BufferedInputStream(fis);
		//构造方法接收字节输出流，增加缓冲区的功能(字节数组)
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int data = 0;
		
		//获得毫秒数
		Long t1 = System.currentTimeMillis();
		
		//read直接从缓冲区读
		while((data=bis.read())!=-1){
			bos.write(data);
		}
		
		bis.close();
		bos.close();
		
		//获得毫秒数
		Long t2 = System.currentTimeMillis();
				
		System.out.println("复制完成，共花费" + (t2-t1) + "毫秒");
	}
}