/**
 * ʹ��file��delete�����͵ݹ��㷨ɾ��һ���ļ��У�ɾ�����������ҪɾC�̣�
 */

package test3;

import java.io.File;

public class DeleteDemo {
	public static void main(String[] args) {
		File file = new File("D:/_site_/aab");
		DeleteUtil.deleteFiles(file);
		System.out.println("ɾ���ɹ���");
	}
}
