/**
 *   获取一个文件夹下所有指定后缀名(.java)的文件（包括子文件夹中的内容），
 *   并将这些文件的绝对路径写入到一个文本文件中
 */

package test2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirDemo {
	public static void main(String[] args) {
		//描述某个路径
		File dir = new File("D:\\_site_\\aaa");
		
		//获取一个容器
		List<File> list = new ArrayList<File>();
		
		//文件对象先放入集合
		DirUtil.fileToList(dir, list);
		
		//创建一个javaList.txt文件夹
		File file = new File(dir, "JavaList.txt");  //dir父目录
		
		//在新文件夹下写入
		DirUtil.writeToFile(list, file.toString());
		
		System.out.println(list);
	}
}
