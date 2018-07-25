package video.note.calendarDemo;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();  //������ͨ������ʵ��������������󣬵õ����������
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR));  //��ȡ��
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));
		
		//����ʱ��
		calendar.set(Calendar.YEAR, 2019);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.getTimeInMillis());  //��ȡ������ 1970 �� 1 �� 1 �� 00:00:00
	}
}
