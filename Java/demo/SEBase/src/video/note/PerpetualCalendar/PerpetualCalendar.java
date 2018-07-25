/*
	万年历
 */

package video.note.PerpetualCalendar;

import java.util.Scanner;

public class PerpetualCalendar {
	public static void main(String[] args){
		//定义变量
		int year;	//保存输入的年
		int month;	//保存输入的月
		int days = 0;	//保存指定月的天数
		int totalDays = 0;	//保存总的天数差
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
		
		//计算年的总天数
		for(int i=1990; i<year; i++){
			if(i%400==0||(i%4==0&&i%100!=0)){
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		
		//计算输入月份之前的天数和
		for(int i=1; i<=month; i++){
			//判断每月的天数
			switch(i){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					days = 31;
					break;
				case 2:
					if(isRn){
						days = 29;
					} else {
						days = 28;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					days = 30;
					break;
				default:
					System.out.println("您输入的月份有误");
			}
			
			//输入月的天数保存到days变量中，但没有累加进去
			if(i!=month){
				totalDays += days;
			}
		}
		
		//求出是星期几，其实就是前面的制表符\t的个数
		int beforeDays;
		beforeDays = 1 + totalDays % 7;
		
		if(beforeDays == 7){
			beforeDays = 0;	//代表星期天，0个\t
		}
		
		System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		
		//先打印\t
		for(int i=0; i<beforeDays; i++){
			System.out.print("\t");
		}
		
		for(int i=1; i<days; i++){
			System.out.print(i + "\t");
			//满7个换行
			if((i+beforeDays)%7 == 0){
				System.out.println();
			}
		}
	}
}
