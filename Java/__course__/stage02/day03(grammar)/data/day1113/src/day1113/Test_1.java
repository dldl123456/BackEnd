package day1113;

import java.util.Scanner;

public class Test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double score = 0;// 成绩
		char level = 0;// 登记
		Scanner input = new Scanner(System.in);
		System.out.println("请输入成绩：");
		score = input.nextDouble();
		if (score > 100 || score < 0) {
			System.out.println("分数有误！");
			return;
		}
		if (score>=90) {
			level = 'A';
		}else if (score>=80) {
			level='B';
		}else if (score>=70) {
			level='C';
		}else if (score>=60) {
			level='D';
		}else{
			level='E';
		}
		System.out.println("等级为："+level);
	}

}
