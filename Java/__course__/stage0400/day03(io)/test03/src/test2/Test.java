/*
	输出一个文件夹中的所有内容,使用File和递归函数来实现
 */

package test2;

import java.io.File;

public class Test {
	public static void main(String[] args) {
        File file = new File("C:/Users/hjkjkj/Desktop/java");
        RecursionOutputFileDemo.OutputFileDemo(file);
    }
}