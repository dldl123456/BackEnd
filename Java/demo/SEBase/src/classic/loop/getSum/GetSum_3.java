/*
 *  从键盘输入一个正整数n，求1+2+3+...+n之和并输出。
 */

package classic.loop.getSum;

import java.util.Scanner;

public class GetSum_3 {
	public static void main(String[] args) {
		System.out.print("请输入一个正整数：");
		
		int num = 0;  //用来保存用户输入的正整数
		int sum = 0;  //用来保存求和的结果
		
		//输入
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//求和
		for(int i=1; i<=num; i++){
			System.out.print(i > 1 ? " + " + i : i);
			sum += i;
		}
		
		//输出
		System.out.println(" = " + sum);
	}
}
