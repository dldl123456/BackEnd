package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssistClass {
	/**
	 * ��ʾ��ǰʱ��
	 * @author Administrator
	 *
	 */
	public static void nowTime() {
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��  HH��mm��ss��");
		String str = sdf1.format(date);
		System.out.println("��ǰʱ�䣺"+str);
	}
}
