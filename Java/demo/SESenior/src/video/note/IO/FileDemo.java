package video.note.IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {
		//描述某个路径
		File file = new File("D:\\_site_\\aaa");
		
		//获得该目录的绝对路径
		System.out.println(file.getAbsolutePath());
		
		//获得上一级目录的字符串
		System.out.println(file.getParent());
		
		//判断是否是文件夹或者目录
		System.out.println(file.isDirectory());
		
		//判断是否是文件
		System.out.println(file.isFile());
		
		//判断目录是否存在
		System.out.println(file.exists());
		
		//目录大小
		System.out.println(file.length());
		
		//查看是否能删除,有删除操作(只能删除空目录)
		System.out.println(file.delete());
		
		//创建目录(文件夹)
		File myFile = new File("D:\\_site_\\aaa");
		System.out.println(myFile.mkdirs());
		
		//创建文件
		File myFile2 = new File("D:/_site_/aaa/ca.txt");
		try {
			System.out.println(myFile2.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查看文件下所有文件名和目录名
		String[] files = file.list();
		for(String i:files){
			System.out.println(i);
		}
		
		//过滤想要的文件或目录(匿名内部类)
		//构建接口的实现类对象
		//把满足条件的收集到对应的数组中
		String[] files1 = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//要满足的条件
				//以.txt结尾的文件
				return name.endsWith(".txt");
			}
		});
		for(String i1:files1){
			System.out.println(i1);
		}
		
		//到指定的目录去查找，返回一个文件数组
		//文件和目录的大小(字节)
		File[] files2 = file.listFiles();
		for(File i2:files2){
			System.out.println(i2.getName() + "--" + i2.length());
		}
		
		File[] files3 = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		for(File i3:files3){
			System.out.println(i3.getName() + "--" + i3.length());
		}
		
		//接口的实现类
		File[] files4 = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		});
		for(File i4:files4){
			System.out.println(i4.getName() + "--" + i4.length());
		}
	}
}
