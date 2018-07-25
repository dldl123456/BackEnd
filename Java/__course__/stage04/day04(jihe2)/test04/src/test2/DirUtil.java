package test2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DirUtil {
	//文件对象先放入集合
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
			
			System.out.println("写入成功！");

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
