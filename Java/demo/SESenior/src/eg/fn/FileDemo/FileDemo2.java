/*
 *  递归实现删除文件或目录和 测试类程序
 */

package eg.fn.FileDemo;

import java.io.File;

class RecursionDeleteFileDemo {  // 利用递归 删除 文件或目录 操作
	public static void deleteFiles(File file) {
		// 递归出口
		// 判断目前文件，如果是文件 或 是一个空的文件夹，则删除
		if (file.isFile() || file.list().length == 0) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				// 递归入口
				deleteFiles(f);
				f.delete();
			}
		}
	}
}

public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("D:/_site_/aaa/aa");
		RecursionDeleteFileDemo.deleteFiles(file);
		System.out.println("删除成功！");
	}
}
