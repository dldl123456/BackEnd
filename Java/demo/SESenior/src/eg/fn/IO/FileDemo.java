/*
 * 将一个指定目录下的java文件的绝对路径，存储到一个文本中
 * 建立一个java的文件列表
 */

package eg.fn.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("D:\\_site_\\aaa");
		List<File> list = new ArrayList<File>();
		fileToList(dir, list);
		// System.out.println(list.size());
		File file = new File(dir, "javaList.txt");// dir父目录
		writeToFile(list, file.toString());
	}

	// 文件对象先放入集合
	public static void fileToList(File dir, List<File> list) {
		if (dir != null) {
			if (dir.isDirectory()) {
				File[] files = dir.listFiles();  //文件对象数组
				for (File file : files) {
					fileToList(file, list);
				}
			} else {
				if (dir.getName().endsWith(".java")) {
					list.add(dir);
				}
			}
		}
	}

	// 写入文本中
	public static void writeToFile(List<File> list, String javaListFile) {
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(javaListFile));
			for (File f : list) {
				String path = f.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();
			}

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (bufw != null) {
					bufw.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
