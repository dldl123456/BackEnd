/**
 * 使用file类delete方法和递归算法删除一个文件夹（删除需谨慎，不要删C盘）
 */

package test3;

import java.io.File;

public class DeleteDemo {
	public static void main(String[] args) {
		File file = new File("D:/_site_/aab");
		DeleteUtil.deleteFiles(file);
		System.out.println("删除成功！");
	}
}
