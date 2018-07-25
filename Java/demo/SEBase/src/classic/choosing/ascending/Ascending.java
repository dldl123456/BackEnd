/*
 *  从键盘输入两个数，然后按升序输出。 
 */

package classic.choosing.ascending;

import java.util.Scanner;

public class Ascending {
	public static void main(String[] args) {
		System.out.print("请输入两个正整数，用空格隔开：");
		
		int num1 = 0,  //用来保存一个正整数
			num2 = 0;  //用来保存一个正整数
		
		//输入两个正整数
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		//比较大小并升序输出
		if(num1<num2){
			System.out.println("升序输出为：\n" + num1 + "," +num2);
		} else {
			System.out.println("升序输出为：\n" + num2 + "," +num1);
		}
	}
}
