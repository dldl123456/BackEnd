/*
 *  从键盘输入一个百分制分数，将其转化为等级分输出。
 */

package classic.choosing.score;

import java.util.Scanner;

public class Score_2 {
	public static void main(String[] args) {
		System.out.print("请输入你的分数：");
		
		double score = 0;  //用来保存你的分数
		String level = "";  //等级
		
		//输入分数
		Scanner in = new Scanner(System.in);
		score = in.nextDouble();
		
		//判断所输入分数是否在0-100区间内
		while(score>100||score<0){
			System.out.print("分数有误，请重新输入：");
			score = in.nextInt();
		}
		
		in.close();
		
		//将其转换成等级输出
		if(score>=90){
			level = "A";
		} else if(score>=80) {
			level = "B";
		} else if(score>=70) {
			level = "C";
		} else if(score>=60) {
			level = "D";
		} else {
			level = "E";
		}
		
		System.out.println("等级为：" + level);
	}
}
