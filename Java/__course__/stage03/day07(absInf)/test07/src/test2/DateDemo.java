/*
 *  ��д�����ȡ��ǰ����ʱ�䲢ת������Ӧ�ĸ�ʽ���(�磺2015-09-09 12:52:23)
 */

package test2;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();  //����ϵͳĬ��ʱ��
		DateFormat df = null;  //���ڸ�ʽ����
		df = DateFormat.getDateTimeInstance();  //ʱ���ʽ����
		System.out.println(df.format(date));  //���
	}
}