package test2;

import java.io.File;

public class RecursionOutputFileDemo {
	public static void OutputFileDemo(File file) {
        File[] list = file.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isDirectory()) {           //isDirectory()方法判断是否为文件夹
                System.out.println(list[i].getName());
            } else {
                System.out.println(list[i].getName()+ "..........文件夹..........");
                OutputFileDemo(list[i]);    //递归调用
            }
        }
    }
}
