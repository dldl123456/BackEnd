/*
	Ҫ�󣺽�D�̸�Ŀ¼�µ�src.mp3�ļ����Ƶ�ͬһĿ¼�²�����Ϊdes.mp3
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
		
		System.out.println("src.mp3��·��Ϊ" + fileSrc + "��ʼ���ƣ�");
		
		try {
			FileCopyUtil.copyFile(fileSrc, fileDes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fileSrc.exists()){
			if(fileDes.exists()){
				System.out.println("�ļ����Ƴɹ���");
			}else{
				System.out.println("�ļ�����ʧ�ܣ�");
			}
		}else{
			System.out.println("�ļ������ڣ�");
		}
		
		System.out.println("des.mp3��·��Ϊ" + fileDes);
	}
}