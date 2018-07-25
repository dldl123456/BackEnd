/*
 * 从键盘输入两个整数，分别求出其和差积商
 */

package test2;

import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		int num1 = 0,  //定义正整数num1
			num2 = 0;  //定义正整数num2
		
		int sum = 0,  //定义两个正整数之和
			diff = 0,  //定义两个正整数之差
			product = 0;  //定义两个正整数之积
		
		double quotient = 0.0;  //定义两个正整数之商
		
		System.out.print("请输入2个整数，用空格隔开：");
		
		//输入这两个正整数
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		sum = num1 + num2;  //求和
		diff = num1 - num2;  //求差
		product = num1 * num2;  //求积
		
		//求商并四舍五入取两位有效有效数字
		quotient = Math.round((double)num1/num2*100)*0.01;
		
		/*double quotientResult= (double)num1 / num2; 
		String quotient = String.format("%.2f", quotientResult);*/
		
		//输出这两个正整数的和差积商的结果
		System.out.println("num1和num2两个整数之间的和为：" + sum);
		System.out.println("num1和num2两个整数之间的差为：" + diff);
		System.out.println("num1和num2两个整数之间的积为：" + product);
		System.out.println("num1和num2两个整数之间的商为：" + quotient);
	}
}
