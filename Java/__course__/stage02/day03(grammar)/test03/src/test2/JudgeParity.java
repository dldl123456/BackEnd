/*
 * 写一个程序,从键盘中输入0到100之间的数,并输出打印该数是奇数还是偶数.
 */

package test2;

import java.util.Scanner;

public class JudgeParity {
	public static void main(String[] args) {
		System.out.print("请输入一个0到100之间的整数：");
		
		int num = 0;  //用来保存用户输入的数字
		
		//输入
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		while(num<0||num>100){
			System.out.print("您的输入有误，请重新输入：");
			num = in.nextInt();
		}
		in.close();
		
		//判断奇偶
		if(num%2==0){
			System.out.println("您输入的数字为偶数！");
		}else{
			System.out.println("您输入的数字为奇数！");
		}
	}
}
