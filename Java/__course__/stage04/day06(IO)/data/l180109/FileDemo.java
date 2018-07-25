package com.lesson.phase4.l0907.l180109;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		
		
		//路径分隔符
		System.out.println(File.pathSeparator);
		//盘符
		System.out.println(File.separator);
		
		
		File file = new File("D:/test2");
		System.out.println(file.exists());
		System.out.println(file.mkdir());
		System.out.println(file.delete());//只能删除文件和空文件夹
		System.out.println(file.mkdirs());
		file = new File("D:/test2/test.txt");
		System.out.println(file.createNewFile());
		System.out.println(file.delete());
		
		file = new File("D:/ioTest2");
		String[] list = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("-----------");
		File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		});
		FileOutputStream fos = new FileOutputStream("D:/testFileName.txt");
		String ln = "\r\n";
		for (File file2 : files) {
			System.out.println(file2);
			fos.write(file2.toString().getBytes());
			fos.write(ln.getBytes());
		}
		fos.close();
		
		
		FileInputStream fis = new FileInputStream("D:/testFileName.txt");
		byte[] by = new byte[1024];
		int len = -1;
		while((len = fis.read(by)) >0){
			System.out.println(new String(by,0,len));
		}
		fis.close();
		
	}
}
