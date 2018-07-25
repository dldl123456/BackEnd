package com.iotek.util;

import java.text.ParseException;
//import java.sql.Timestamp;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
//import java.util.List;
import java.util.Scanner;

//import com.zhizuobiao.dao.impl.AdminDao;
//import com.zhizuobiao.entity.ShowHall;

/**
 * 帮助类
 * @author 肖宏达
 *
 */
public class Util{
	
	private static Scanner in = new Scanner(System.in);

	/**
	 *从键盘获取String类型数据
	 * @param str
	 * 接收String类型的数据
	 * @return 
	 */
	public static String getString(String str) {
		System.out.println(str);
		return in.nextLine();
	}

	/**
	 * 从键盘端获取int类型数据
	 * @param str
	 * 如果输入非整型的数据会提示错误
	 * 输入小于0的整形数据也提示错误
	 * 输入非负整数isOK
	 * @return num
	 */
	public  static int getInt(String str) {
		System.out.println(str);
		while (true) {
			try {
				String strs=in.nextLine();
				if(Integer.valueOf(strs) instanceof Integer){
					int num=Integer.valueOf(strs);
					if(num>=0){
						return num;
					}
					else{
						System.out.println("请输入正整数");
					}
				}
				
			} catch (Exception e) {
				System.out.println("请输入正整数!");
			}
		}
	}
	/**
	 * 获取double类型的数据
	 * @param str
	 * 当且仅当输入的内容为非负数浮点数跳出方法
	 * @return num
	 */
	public  static double getDouble(String str) {
		System.out.println(str);
		while (true) {
			try {
				String strs=in.nextLine();
				if(Double.valueOf(strs) instanceof Double){
					double num=Double.valueOf(strs);
					if(num>=0){
						return num;
					}
					else{
						System.out.println("请输入非负数");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("请输入数字!");
			}
		}
	}
	/**
	 * 获取java.sql.Date对象2
	 * 当且仅当输入正确格式会返回Date对象并跳出方法
	 * @param str
	 * @return
	 */
	public static Date getDate(String str){
		Date date=null;
		System.out.println(str);
		while(true){
			System.out.println("请按规范格式输写： yyyymmdd 比如：19210109");
			str=in.nextLine();
			SimpleDateFormat dt=new SimpleDateFormat("yyyyMMdd");
			 java.util.Date date2;
			try {
				dt.setLenient(false);
				date2 = dt.parse(str);
				date=new Date(date2.getTime());
				return date;
			} catch (ParseException e) {
				
				System.out.println("请按照格式书写！！！");
			}
			
		}
	}
	/**
	 * 键盘获取时间类对象1
	 * @param str
	 * 当且仅当格式正确可继续运行
	 * @return
	 */
	public static Timestamp getTimestamp(String str){
		System.out.println(str);
		Timestamp ts=null;
				while(true){
					try{
						System.out.println("请按规范格式输写：yyyymmdd HHmm 比如：19210109 1403");
						str=in.nextLine();
						SimpleDateFormat dt=new SimpleDateFormat("yyyyMMdd HHmm");
						dt.setLenient(false);
						java.util.Date date2=dt.parse(str);
						ts=new Timestamp(date2.getTime());
						return ts;
						}catch(Exception e){
							System.out.println("请输入正确的格式！！！");
						}
					}
	}
	/**
	 * 关闭Scanner
	 */
	public static void closeScanner(){
			if(in !=null){
				in.close();
				in=null;
				System.out.println("已经关闭Scanner");
			}
		}
}