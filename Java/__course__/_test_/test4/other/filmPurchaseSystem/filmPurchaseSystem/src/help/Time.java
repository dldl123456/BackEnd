package help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Time {
	//yyyy-MM-dd HH:mm yyyy��MM��dd�� HHʱmm��  yyyyMMddHHmm
	static Scanner input = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	public static String nowTime() {
		Date date = new Date();
		String str = sdf.format(date);
		return str;
	}
	//����ʱ�䲢ת��ΪDate����
	public static Date StringToDate() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		a:while(true) {
			String time = input.next();
			try {
				Date date = sdf.parse(time);
				//System.out.println(date);
				return date;
			} catch (ParseException e) {
				System.out.println("�������ʱ�����ʹ���ϵͳ�޷�ʶ���밴��ģ����ʽ����(yyyyMMddHHmm)(�������뷨)");
				continue a;
			}
		}
	}
	
	public static Date StringToDate(String strtime) {
		try {
			Date date = sdf.parse(strtime);
			//System.out.println(strtime);
			return date;
		} catch (ParseException e) {
			System.out.println("�������ʱ�����ʹ���ϵͳ�޷�ʶ���밴��ģ����ʽ����\n\t(yyyyMMddHHmm)");
			//strtime = input.next();
		}
		return null;
	}
	public static String DateToString(Date time) {
		String strtime = sdf.format(time);
		return strtime;
	}
	public static Date StringToDate1(String strtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = sdf.parse(strtime);
			return date;
		} catch (ParseException e) {
			System.out.println("�������ʱ�����ʹ���ϵͳ�޷�ʶ���밴��ģ����ʽ����\n\t(yyyyMMdd)");
		}
		return null;
	}
	public static String DateToString1(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strtime = sdf.format(time);
		return strtime;
	}
	/**
	 * ��ӳ���ʱ�Ƚ��Ƿ�������ʱ�䷶Χ��
	 * @param starttime���г��ο�ʼʱ��
	 * @param stoptime����ʱ��
	 * @param time��Ҫ��ӵ�ʱ��
	 * @return
	 */
	public static boolean compareTo1(Date starttime,Date stoptime,Date time) {
		if(time.after(starttime)&&time.before(stoptime)) {
			return false;
		}else {
			return true;
		}	
	}
	/**
	 * �ж�ʱ���Ƿ�Ϻ�����
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean compareTo2(Date time1,Date time2) {
		if(time1.before(time2)) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean compareTo3(Date time1,Date time2) {
		double t1 = (double)(time1.getTime());
		double t2 = (double)(time2.getTime());
		double i = (t2-t1)/1000/60/60;
		if(i<=3) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean compareTo4(Date time) {
		double t1 = (double)(new Date().getTime());
		double t2 = (double)(time.getTime());
		//System.out.println("t2:"+t2+"t1:"+t1);
		double i = (t2-t1)/1000/60/60/24;
		//System.out.println(i);
		if(i>0&&i<3) {
			return true;
		}else {
			return false;
		}
	}
}
