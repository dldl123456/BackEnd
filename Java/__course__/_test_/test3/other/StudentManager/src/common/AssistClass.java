package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssistClass {
	/**
	 * 显示当前时间
	 * @author Administrator
	 *
	 */
	public static void nowTime() {
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日  HH点mm分ss秒");
		String str = sdf1.format(date);
		System.out.println("当前时间："+str);
	}
}
