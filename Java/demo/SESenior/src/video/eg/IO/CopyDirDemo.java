package video.eg.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDirDemo {
	public static void main(String[] args) {
		try {
			CopyDirUtil.copyDir(new File("D:\\_site_\\aaa"), new File("D:\\_site_\\aac"));
			System.out.println("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class CopyDirUtil{
	public static void copyDir(File src, File dst) throws IOException{
		//dst.mkdir();不加s若D:\_site_\aaa没有_site_文件夹，则无法创建
		dst.mkdirs();  //创建目标文件夹
		//如果源文件夹不为空
		if(src!=null){
			//遍历源文件夹里所有的内容(文件和目录)
			File[] files = src.listFiles();
			//
			if(files!=null){
				//假设是文件
				for(File f:files){
					if(f.isFile()){
						//复制文件(用字节流)
						FileInputStream fis = new FileInputStream(f);
						//复制到
						FileOutputStream fos = new FileOutputStream(dst.getAbsolutePath() + "\\" + f.getName());
						
						//为了提升效率，创建一个缓冲区数组
						//自定义一个1M的字节缓冲区
						byte[] buff = new byte[1024*1024];
						
						int len = 0;  //读到的字节个数
						
						//读到字节缓冲区中，赋值给len,到-1说明到文件末尾
						while((len=fis.read(buff))!=-1){
							fos.write(buff, 0, len);
						}
						
						//释放资源
						fis.close();
						fos.close();
					}else{
						//假设不是文件，递归
						copyDir(f, new File(dst.getAbsolutePath()+ "\\" + f.getName()));
					}
				}
			}
		}
	}
}
