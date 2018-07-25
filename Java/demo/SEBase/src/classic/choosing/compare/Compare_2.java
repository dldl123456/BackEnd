/*
 *  从键盘输入三个整数，求出最大数并输出。 
 */

package classic.choosing.compare;

import java.util.Scanner;

public class Compare_2 {
	public static void main(String[] args) {
		System.out.println("请输入三个正整数：");
		
		int num1 = 0,  //定义正整数num1
			num2 = 0,  //定义正整数num2
			num3 = 0;  //定义正整数num3
				
		int max = 0;  //定义三个正整数中的最大值
				
		//输入这三个正整数
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		in.close();
			
		//求最大值
		max = (num1>num2?(num1>num3?num1:num3):(num2>num3?num2:num3));
		
		//输出最大值
		System.out.println(num1 + "," + num2 + "," + num3 + "中最大值为：" + max);
	}
}
