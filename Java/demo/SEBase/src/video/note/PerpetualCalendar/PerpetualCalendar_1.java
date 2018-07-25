/*
	万年历（第一步==>if方法）
 */

package video.note.PerpetualCalendar;

import java.util.Scanner;

public class PerpetualCalendar_1 {
	public static void main(String[] args){
		//定义变量
		int year;	//保存输入的年
		int month;	//保存输入的月
		int days = 0;	//保存指定月的天数
		boolean isRn;	//闰年保存true,否则为false
		System.out.println("*****使用万能历*****");
		
		Scanner in = new Scanner(System.in);
		
		//输入年和月
		System.out.print("请输入年：");
		year = in.nextInt();
		
		System.out.print("请输入月：");
		month = in.nextInt();
		
		in.close();
		
		//判断是否为闰年
		if((year%400==0)||(year%4==0&&year%100!=0)){
			isRn = true;
		} else {
			isRn = false;
		}
		
		if(isRn){
			System.out.println("您输入的年份是闰年");
		} else {
			System.out.println("您输入的年份不是闰年");
		}
		
		//判断每月的天数
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			days = 31;
		} else if(month==2) {
			if(isRn){
				days = 29;
			} else {
				days = 28;
			}
		} else if(month==4||month==6||month==9||month==11){
			days = 30;
		} else {
			System.out.println("您输入的月份有误");
		}
		
		System.out.println(year + "年" + month + "月对应的天数为" + days);
		
	}
}
