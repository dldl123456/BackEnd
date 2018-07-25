package video.note.calendarDemo;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();  //抽象类通过子类实例化构建子类对象，得到其子类对象
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR));  //获取年
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));
		
		//设置时间
		calendar.set(Calendar.YEAR, 2019);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.getTimeInMillis());  //获取毫秒数 1970 年 1 月 1 日 00:00:00
	}
}
