/**
 *   ��ȡһ���ļ���������ָ����׺��(.java)���ļ����������ļ����е����ݣ���
 *   ������Щ�ļ��ľ���·��д�뵽һ���ı��ļ���
 */

package test2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirDemo {
	public static void main(String[] args) {
		//����ĳ��·��
		File dir = new File("D:\\_site_\\aaa");
		
		//��ȡһ������
		List<File> list = new ArrayList<File>();
		
		//�ļ������ȷ��뼯��
		DirUtil.fileToList(dir, list);
		
		//����һ��javaList.txt�ļ���
		File file = new File(dir, "JavaList.txt");  //dir��Ŀ¼
		
		//�����ļ�����д��
		DirUtil.writeToFile(list, file.toString());
		
		System.out.println(list);
	}
}
