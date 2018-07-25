/*
 *  从键盘输入一个百分制分数，将其转化为等级分输出。
 */

package classic.choosing.score;

import java.util.Scanner;

public class Score_1 {
	public static void main(String[] args) {
		System.out.print("请输入你的分数：");
		
		int score = 0;  //用来保存你的分数
		
		//输入分数
		Scanner in = new Scanner(System.in);
		score = in.nextInt();
		in.close();
		
		//将其转换成等级输出
		int grade = 0;
		grade = score/10;
		
		switch(grade){
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
			default:
				System.out.println("E");
		}
	}
}
