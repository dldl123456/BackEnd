package test2;

import java.io.File;

public class RecursionOutputFileDemo {
	public static void OutputFileDemo(File file) {
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isDirectory()) {           //isDirectory()�����ж��Ƿ�Ϊ�ļ���
                System.out.println(list[i].getName());
            } else {
                System.out.println(list[i].getName()+ "..........�ļ���..........");
                OutputFileDemo(list[i]);    //�ݹ����
            }
        }
    }
}
