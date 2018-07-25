package course.note.file;

import java.io.File;
import java.util.LinkedList;

/**
 * 文件遍历
 */

public class Class3 {
	public static void main(String[] args) {
		//Class3.demo1(new File("D:" + File.separator + "_soft_"));
		
		File file = new File("D:" + File.separator + "1_java");
		demo1(file);
		System.out.println("===============");
		demo2(file);
	}
	
	/**
	 *	递归调用 
	 */
	public static void demo2(File file){
		//获取当前file数组
		File[] files = file.listFiles();
		//给出结束条件
		if(files == null || files.length ==0){  //文件夹下为空
			//递归返回
			return;
		}
		//循环遍历files
		for(File f : files){
			//判断是文件还是文件夹
			if(f.isDirectory()){  //文件夹
				//调用递归，继续遍历
				demo2(f);
			} else {  //文件
				//打印输出
				System.out.println("文件名：" + f.getName());
			}
		}
	}
	
	/**
	 * 非递归调用
	 */
	public static void demo1(File file){
		LinkedList<File> fileList = new LinkedList<>();
		
		//获取当前file数组
		File[] files = file.listFiles();
		//遍历
		for(File f : files){
			//判断是文件还是文件夹
			if(f.isDirectory()){  //文件夹
				//保存起来，数量不确定，用什么来保存（数组还是集合）
				fileList.add(f);
				
			} else {  //文件
				//打印输出
				System.out.println("文件名：" + f.getName());
			}
		}
		
		//当前文件夹下的路径和文件操作完成
		//还有其他情况，就是文件夹里面还有文件夹
		
		//遍历集合中的文件夹
		while(!fileList.isEmpty()){  //集合是否为空（如果不为空）
			File tmpFile = fileList.removeFirst();  //获取集合第一个元素并删除
			// 获取文件夹下的所有内容
			File[] tmpFiles = tmpFile.listFiles();
			//遍历File[]
			for(File f : tmpFiles){
				//判断是文件还是文件夹
				if(f.isDirectory()){  //文件夹
					//保存起来，数量不确定，用什么来保存（数组还是集合）
					fileList.add(f);
					
				} else {  //文件
					//打印输出
					System.out.println("文件名：" + f.getName());
				}
			}
		}
	}
}
