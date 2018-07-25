package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyUtil {
	/**
	 * 复制mp3文件
	 * @param f
	 * @throws IOException 
	 */
	public static void copyFile(File src, File dst) throws IOException{
		// InputStream和outputStream是抽象类，用他们的子类做实例化
		// 创建文件输入流（读取文件中的内容）
		InputStream ins = new FileInputStream(src);
		// 创建文件输出流（写出入文件中的内容）
		OutputStream ous = new FileOutputStream(dst);
		
		//获得毫秒数
		Long t1 = System.currentTimeMillis();
		
		// 创建缓冲区
		// 创建一个1M大小的缓冲区，用来存放输入流中的字节
		byte[] buff = new byte[1024*1024];
		
		int len = 0;  //保存实际读到的字节数
		
		while((len=ins.read(buff))!=-1){  //说明没有读到文件末尾
			//把字节数组中读到的数据写到对应输出流中
			ous.write(buff, 0, len);
		}
		
		//释放资源
		ins.close();
		ous.close();
		
		//获得毫秒数
		Long t2 = System.currentTimeMillis();
		System.out.println("复制完成，共花费" + (t2-t1) + "毫秒");
	}
}
