package course.note.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO和file类
 */

public class Class2 {
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public  static void test1() throws IOException{
		File file = new File("d:/123/abc.txt");
		
		file.createNewFile();  //创建文件
		
		file.listFiles();
	}
	
	public static void test2(){
		//字节流
		//复制一个文件到其他位置
		File file = new File("d:/123/bb.txt");
		
		//定义一个输入流读取这个文件
		InputStream fis = null;
		
		//输出(复制)到指定路径
		OutputStream fos = null;
		
		try{
			
			fis = new FileInputStream(file);
			
			fos = new FileOutputStream(new File("d:/123/dd.txt"));
			
			//读
			
			//定义缓冲区
			byte[] buff = new byte[024*1024];  //字节数组
			int len = 0; //fis.read(buff);  //返回当前读了多少
			
			//等于-1结束，不等于-1继续读
			while((len = fis.read(buff)) != -1){  //读到buff数组
				//保存
				fos.write(buff, 0, len);  //把buff数组中的内容写到磁盘上
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			//关闭流
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
