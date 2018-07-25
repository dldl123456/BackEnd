package video.note.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStringOutInputStringDemo {
	public static void main(String[] args) {
		try {
			FileCopyUtil.copy(new File("D:/_site_/aaa/JavaList.txt"), new File("D:/_site_/aab/JavaList1.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class FileCopyUtil{
	//拷贝一个文件到另一个目录下(源，目标)
	//往外抛异常，让调用这个方法的人去处理
	public static void copy(File src, File dst) throws IOException{
		//创建文件输入流（读取文件中的内容）
		FileInputStream fis = new FileInputStream(src);
		//创建文件输出流（写出文件中的内容）
		FileOutputStream fos = new FileOutputStream(dst);
		
		//获得毫秒数
		Long t1 = System.currentTimeMillis();
		
		/*第一种方法*/
		/*int data = -1;
		
		//从输入流中读取
		while(fis.read()!=-1){
			fos.write(data);
		}*/
		
		/*第二种方法*/
		//先放到缓冲区
		//创建一个1M大小的缓冲区，用来存放输入流中的字节
		byte[] buf = new byte[1024*1024];
		
		int len = 0;  //保存实际读到的字节数
		
		while((len=fis.read(buf))!=-1){  //说明没有读到文件末尾
			//把字节数组中读到的数据写到对应输出流中
			fos.write(buf, 0, len);
		}
		
		//释放资源
		fis.close();
		fos.close();
		
		//获得毫秒数
		Long t2 = System.currentTimeMillis();
		
		System.out.println("复制完成，共花费" + (t2-t1) + "毫秒");
	}
}