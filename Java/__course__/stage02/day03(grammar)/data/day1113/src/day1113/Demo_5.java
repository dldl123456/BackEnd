package day1113;

import java.util.Scanner;

public class Demo_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1，4，7上课，2，3，5预习，6休息
		int day = 0;// 哪天
		String dose = null;// 干啥
		Scanner input = new Scanner(System.in);
		System.out.println("please input day:");
		day = input.nextInt();
		switch (day) {//枚举，int，char，short，byte，String
		case 1:
		case 4:
		case 7:
			dose = "上课";
			break;
		case 2:
		case 3:
		case 5:
			dose = "预习";
			break;
		case 6:
			dose = "休息";
			break;

		default:
			System.out.println("输入错误！");
			break;
		}
//		if (day==1||day==4||day==7) {
//			dose = "上课";
//		}else if (day==2||day==3||day==5) {
//			dose = "预习";
//		}else if (day==6) {
//			dose = "休息";
//		}else {
//			System.out.println("输入错误！");
//		}
		System.out.println(dose);
		
	}
	

}
