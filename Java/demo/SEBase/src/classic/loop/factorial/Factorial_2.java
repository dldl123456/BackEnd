/*
 *  从键盘输入一个正整数，求出其阶乘并输出。
 */

package classic.loop.factorial;

import java.util.Scanner;

public class Factorial_2 {
	public static void main(String[] args) {
		System.out.print("请输入一个正整数：");
		
		int n = 0;  //用来保存用户输入的正整数
		int res = 1;  //用来保存计算的结果
		
		//输入
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		//计算结果
		for(int i=1; i<=n; i++){
			System.out.print(i > 1 ? " * " + i : i);
			res *= i;
		}
		
		//输出
		System.out.println(" = " + res);
	}
}
