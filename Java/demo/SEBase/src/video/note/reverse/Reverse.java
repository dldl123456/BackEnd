/*
 *  输入一个正整数，把整数逆序输出
 */

package video.note.reverse;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		System.out.print("请输入一个正整数：");
		
		int num = 0;  //用来保存用户输入的正整数
		int res = 0;  //用来保存逆序输出的结果
		
		//输入
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//逆序输出
		System.out.print("您输入的正整数倒序为：");
		while(num!=0){
			res = num % 10;
			System.out.print(res);
			num /= 10;
		}
		
	}
}
