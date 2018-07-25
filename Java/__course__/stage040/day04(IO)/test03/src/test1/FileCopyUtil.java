package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyUtil {
	/**
	 * ����mp3�ļ�
	 * @param f
	 * @throws IOException 
	 */
	public static void copyFile(File src, File dst) throws IOException{
		// InputStream��outputStream�ǳ����࣬�����ǵ�������ʵ����
		// �����ļ�����������ȡ�ļ��е����ݣ�
		InputStream ins = new FileInputStream(src);
		// �����ļ��������д�����ļ��е����ݣ�
		OutputStream ous = new FileOutputStream(dst);
		
		//��ú�����
		Long t1 = System.currentTimeMillis();
		
		// ����������
		// ����һ��1M��С�Ļ���������������������е��ֽ�
		byte[] buff = new byte[1024*1024];
		
		int len = 0;  //����ʵ�ʶ������ֽ���
		
		while((len=ins.read(buff))!=-1){  //˵��û�ж����ļ�ĩβ
			//���ֽ������ж���������д����Ӧ�������
			ous.write(buff, 0, len);
		}
		
		//�ͷ���Դ
		ins.close();
		ous.close();
		
		//��ú�����
		Long t2 = System.currentTimeMillis();
		System.out.println("������ɣ�������" + (t2-t1) + "����");
	}
}
