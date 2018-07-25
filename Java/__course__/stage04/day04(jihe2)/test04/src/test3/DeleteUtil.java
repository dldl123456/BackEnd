package test3;

import java.io.File;

public class DeleteUtil {
	public static void deleteFiles(File file) {
		// 递归出口
		// 判断目前文件，如果是文件 或 是一个空的文件夹，则删除
		if (file.isFile()||file.list().length==0) {
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
