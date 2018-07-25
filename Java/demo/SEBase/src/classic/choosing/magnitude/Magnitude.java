/*
 *  从键盘输入一个实数，求其绝对值并输出。 
 */

package classic.choosing.magnitude;

import java.util.Scanner;

public class Magnitude {
	public static void main(String[] args) {
		System.out.print("请输入一个任意实数：");
		double num = 0.0;
		double numAbs = 0.0;
		
		//输入一个任意实数
		Scanner in = new Scanner(System.in);
		num = in.nextDouble();
		in.close();
		
		//求该实数的绝对值
		numAbs = Math.abs(num);
		
		//输出该实数的绝对值
		System.out.println("该实数的绝对值是：" + numAbs);
	}
}
