package test3;

import java.io.File;

public class DeleteUtil {
	public static void deleteFiles(File file) {
		// �ݹ����
		// �ж�Ŀǰ�ļ���������ļ� �� ��һ���յ��ļ��У���ɾ��
		if (file.isFile()||file.list().length==0) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				// �ݹ����
				deleteFiles(f);
				f.delete();
			}
		}
	}
}
