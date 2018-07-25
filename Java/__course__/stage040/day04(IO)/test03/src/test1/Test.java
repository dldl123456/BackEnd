/*
	要求：将D盘根目录下的src.mp3文件复制到同一目录下并命名为des.mp3
 */

package test1;

import java.io.File;
import java.io.IOException;

public class Test {
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		File fileSrc = new File("D:" + File.separator + "src.mp3");
		File fileDes = new File("D:" + File.separator + "des.mp3");
		
		System.out.println("src.mp3的路径为" + fileSrc + "开始复制！");
		
		try {
			FileCopyUtil.copyFile(fileSrc, fileDes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fileSrc.exists()){
			if(fileDes.exists()){
				System.out.println("文件复制成功！");
			}else{
				System.out.println("文件复制失败！");
			}
		}else{
			System.out.println("文件不存在！");
		}
		
		System.out.println("des.mp3的路径为" + fileDes);
	}
}