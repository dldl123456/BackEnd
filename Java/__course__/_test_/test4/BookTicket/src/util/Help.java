package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @param 工具类，用户输入
 * @author zmx2321
 *
 */
public class Help {
	//获取输入
	private static Scanner in = new Scanner(System.in);
	//时间格式
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//从控制台输入一个字符串
	public static String getString(String str) {
		System.out.print(str);
		return in.next();
	}

	//从控制台输入一个整型
	public static int getInt(String str) {
		System.out.print(str);
		while (true) {
			try {
				int num = in.nextInt();
				return num;
			} catch (Exception e) {
				System.out.print("您的输入有误，请重新输入\n请输入一个整数：");
				in.nextLine();
			}
		}
	}
	
	//从控制台输入一个浮点数
	public static float getFloat(String str) {
		System.out.print(str);
		while (true) {
			try {
				float num = in.nextFloat();
				return num;
			} catch (Exception e) {
				System.out.print("您的输入有误，请重新输入\n请输入一个小数：");
				in.nextFloat();
			}
		}
	}
	
	//控制台输入一个输入日期
	public static String getData(String str){
		System.out.print(str);
		while (true) {
			String time = in.next();
			try {
				Date date = sdf.parse(time);
				String strtime = sdf.format(date);
				
				return strtime;
			} catch (Exception e) {
				System.out.print("您输入的时间类型错误，系统无法识别，\n请按照模板样式输入(yyyy-MM-dd)：");
				in.nextLine();
			}
		}
	}
	
	//test
	public static void main(String[] args) {
		//System.out.println(getInt("输入数字："));
		
		//System.out.println(getString("输入字符串："));
		
		//System.out.println(getFloat("输入浮点数："));
		
		//System.out.println(getData("输入日期："));
	}
}
