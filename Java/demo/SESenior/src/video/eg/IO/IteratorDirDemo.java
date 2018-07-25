package video.eg.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IteratorDirDemo {
	public static void main(String[] args) {
		IteratorUtil.IteratorDir(new File("D:/_site_/aaa"));
	}
}

class IteratorUtil{
	private static int level = 0;  //保存层级数
	
	//一个对外提供的静态的公开方法
	public static void IteratorDir(File file){
		if(file!=null){
			//找出递归的出口
			//假设是文件或是空文件夹就返回
			if(file.isFile()||file.listFiles().length==0){
				return;
			}else{
				//遍历文件夹中的文件
				File[] files = file.listFiles();
				//要求是先输出文件夹，再输出文件
				files = sort(files);
				//遍历
				for(File f:files){
					//动态字符串
					StringBuilder sb = new StringBuilder();
					if(f.isFile()){
						sb.append(getTab(level));
						sb.append(f.getName());
					}else{
						sb.append(getTab(level));
						sb.append(f.getName());
						sb.append("\\");
					}
					System.out.println(sb.toString());
					
					//如果是文件夹
					if(f.isDirectory()){
						level++;  //进入目录遍历，层级+1
						IteratorDir(f);  //递归，调用遍历目录的方法
						level--;  //目录层级-1返回上一级目录，继续打印输出
					}
				}
			}
		}
	}
	
	//根据层级数得到制表符的个数（所组成的字符串）
	private static String getTab(int level){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<level; i++){
			sb.append("\t");
		}
		
		return sb.toString();
	}
	
	/**
	 *  对File类型的数组进行先目录后文件的排列
	 */
	//只为本类服务的方法
	private static File[] sort(File[] files){
		List<File> fList = new ArrayList<>();
		
		//先存放文件夹
		for(File f:files){
			//如果是文件夹
			if(f.isDirectory()){
				fList.add(f);
			}
		}
		
		//再存放文件
		for(File f:files){
			//如果是文件
			if(f.isFile()){
				fList.add(f);
			}
		}
		
		//把集合中的元素转换成指定大小和指定类型的数组
		return fList.toArray(new File[fList.size()]);
	}
}
