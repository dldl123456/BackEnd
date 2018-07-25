/*
 * 输入3个整数，求3个整数的和、最大值、平均值
 */

package test1;

import java.util.Scanner;

public class Evaluation {
	public static void main(String[] args) {
		int num1 = 0,  //定义正整数num1
			num2 = 0,  //定义正整数num2
			num3 = 0;  //定义正整数num3
		
		int sum = 0,  //定义这三个正整数之和
			max = 0;  //定义三个正整数中的最大值
		double average = 0.0;  ////定义这三个正整数的平均数
		
		System.out.print("请输入3个整数，用空格隔开：");
		
		//输入这三个正整数
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		in.close();
		
		sum = num1 + num2 + num3;  //求和
		max = (num1>num2?(num1>num3?num1:num3):(num2>num3?num2:num3));  //求最大值
		
		//求平均数并并四舍五入取两位有效数字
		average = Math.round((double)sum/3*100)*0.01;
		
		/*double averageResult = (double)sum / 3;
		String average = String.format("%.2f", averageResult);*/
		
		//输出这三个正整数的和、最大值、平均值
		System.out.println("num1、num2、num3求和为：" + sum);
		System.out.println("num1、num2、num3平均数为：" + average);
		System.out.println("num1、num2、num3中最大值为：" + max);
	}
}
