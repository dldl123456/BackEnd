package course.note.file;

import java.io.File;
import java.util.Date;

/**
 * file类
 *
 */

public class Class1 {
	public static void main(String[] args) {
		File file = null;  //声明
		
		//创建目录
		//一个\不行，一个表示转义
		//file = new File("D:\\1_java");
		
		//不同操作系统，分隔符不一样
		//linux  /
		//获取当前操作系统分隔符(separator是静态常量)
		String path = "D:" + File.separator + "1_java";
		String filepath = "D:" + File.separator + "1_java" + File.separator + "Tset1.java";
		String testpath = "D:\\testio8";
		
		System.out.println(path);
		file = new File(path);
		
		//.表示当前，  ..表示上级
		File file2 = new File("./Class.java");
		
		//
		File file3 = new File(filepath);
		
		File file4 = new File(testpath);  //测试重命名
		
		//常用file操作
		
		//判断路径（文件）是否存在
		System.out.println(file.exists());
		
		//获取绝对路径
		System.out.println(file.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		
		//相对路径
		System.out.println(file.getPath());
		System.out.println(file2.getPath());
		
		//返回上一级路径
		System.out.println(file.getParent());
		
		//获取文件名字
		System.out.println(file.getName());
		
		//修改时间....时间戳转换
		System.out.println(new Date(file.lastModified()));
		System.out.println(new Date(file3.lastModified()));
		
		//大小(字节)（文件大小）
		System.out.println(file3.length());
		
		//重命名
		System.out.println(file3.renameTo(new File("D:" + File.separator + "1_java" + File.separator + "Tset5.java")));
		
		System.out.println(file4.renameTo(new File("D:\\testio8")));
		
		//重命名+移动(剪切)
		System.out.println(file4.renameTo(new File("D:\\1_java\\testio4")));
		
		File file5 = new File("D:\\1_java\\testio4\\aaa");
		
		//删除空文件夹或文件
		System.out.println(file5.delete());
		
		//获取文件夹下所有文件
		File[] files = file.listFiles();
		for(File f : files){
			if(f.isFile()){  //如果是文件
				System.out.println("文件名：" + f.getName());
			}else{
				System.out.println("文件夹名：" + f.getName());
			}
		}
		
		//创建文件夹
		File dirFile = new File("D:\\1_java\\aa\\ww\\vvv");
		dirFile.mkdirs();  //创建多级目录
		dirFile.mkdir();  //创建一级目录，要保证父目录存在
	}
}
