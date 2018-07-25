package course.note.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * 转换流
 *
 */

public class Class4 {
	public static void main(String[] args) throws IOException {
		demo1();
		
//		demo2();
	}

	// 字节流变成字符流
	public static void demo1() throws IOException{
		//字节流
		FileInputStream fis = new FileInputStream(new File("D://123//aa.txt"));
		FileOutputStream fos = new FileOutputStream(new File("D://123//bb.txt"));
		//传进来一个InputStream，还有一个参数指定编码格式（utf8，gbk，unicode，iso8859-1...）
		// 字节流变成字符流
		//读写都有编码
		//(字符流)
		//输入字节流 --> 输入字符流
		Reader fid = new InputStreamReader(fis, "gbk");
		//输出字节流 --> 输出字符流
		Writer fiw = new OutputStreamWriter(fos, "iso8859-1");  //读写编码不一致导致乱码
		
		System.out.println("*********IO流操作代码基本相同********");
		
		char[] buff = new char[1024*1024];
		
		int len = 0;
		while((len=fid.read(buff))!=-1){
			// 创建一个字符串，获取字符数组的有效长度
			System.out.println(new String(buff, 0, len));
			fiw.write(buff, 0, len);
		}
		
		System.out.println("*********IO流操作代码基本相同********");
		
		fiw.close();
		fid.close();
	}
	
	//自学内容
	public static void demo2() throws IOException{
		//缓冲流(字节缓冲流，字符缓冲流)-->大文件读取，提高效率（大游戏上G，解压）
		//从磁盘或者网络中读取{从网络中读取，写到磁盘（下载）}
		//内存（图片读到内存，加水印）
		//涉及编码用转换流
		//属性加载，Properties 配置文件操作
		//PrintSreeam打印流（javaweb servlet）(字节，字符)
		//file类扩展RandomAccessFile(文件切割和合并)《网站上传》
		//对象序列化Serializable（java内存中的对象，保存到本地磁盘上）
		//内存  --> ByteArrayInputStream, ByteArrayOutputStream
		//字节缓冲流
		String path1 = "D://123//aa.txt",
			   path2 = "D://123//bb.txt";
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		//创建文件输入输出流（读取写入文件中的内容）
		InputStream fis = new FileInputStream(file1);
		OutputStream fos = new FileOutputStream(file2);
		
		//包装类
		//构造方法接收字节输入输出流，增加缓冲区的功能
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		/**/
		int data = 0;
		//read直接从缓冲区读
		while((data=bis.read())!=-1){
			bos.write(data);
		}
		
		//关闭流
		bis.close();
		bos.close();
	}
}
