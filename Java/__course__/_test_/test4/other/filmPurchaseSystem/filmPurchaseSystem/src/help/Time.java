package help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Time {
	//yyyy-MM-dd HH:mm yyyy年MM月dd日 HH时mm分  yyyyMMddHHmm
	static Scanner input = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	public static String nowTime() {
		Date date = new Date();
		String str = sdf.format(date);
		return str;
	}
	//输入时间并转换为Date类型
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
				System.out.println("您输入的时间类型错误，系统无法识别，请按照模板样式输入(yyyyMMddHHmm)(中文输入法)");
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
			System.out.println("您输入的时间类型错误，系统无法识别，请按照模板样式输入\n\t(yyyyMMddHHmm)");
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
			System.out.println("您输入的时间类型错误，系统无法识别，请按照模板样式输入\n\t(yyyyMMdd)");
		}
		return null;
	}
	public static String DateToString1(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strtime = sdf.format(time);
		return strtime;
	}
	/**
	 * 添加场次时比较是否在已有时间范围内
	 * @param starttime已有场次开始时间
	 * @param stoptime结束时间
	 * @param time需要添加的时间
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
	 * 判断时间是否合乎常理
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
