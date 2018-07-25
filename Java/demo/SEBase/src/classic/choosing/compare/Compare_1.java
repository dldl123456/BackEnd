/*
 * 从键盘输入两个整数，求出较大数并输出。 
 */

package classic.choosing.compare;

import java.util.Scanner;

public class Compare_1 {
	public static void main(String[] args) {
		int num1 = 0,  //用来保存一个正整数
			num2 = 0;  //用来保存一个正整数
		
		int max = 0;  //用来保存较大的正整数
		
		System.out.println("请输入两个正整数，用空格隔开：");
		
		//输入两个正整数
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		//比较两个正整数的大小
		max = num1 > num2 ? num1 : num2;
		
		//输出较大的数
		System.out.println("较大的数为：" + max);
	}
}
