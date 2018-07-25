/*
 * 输入自己的姓名、性别、年龄和想获得的成绩，并打印 
 */

package video.note.prcin;

import java.util.Scanner;

public class Prcin {
	public static void main(String[] args) {
		String name = null;	//姓名
		char sex = 0;	//性别
		byte age = 0;	//年龄
		float score = (float) 0.0;	//想获得的成绩
		
		System.out.println("请输入您的姓名、性别、年龄和想获得的成绩：");
		
		Scanner in = new Scanner(System.in);
		name = in.next();
		sex = in.next().charAt(0);
		age = in.nextByte();
		score = in.nextFloat();
		in.close();
		
		System.out.println("您的姓名是：" + name);
		System.out.println("您的性别是：" + sex);
		System.out.println("您的年龄是：" + age);
		System.out.println("您想获得的成绩是：" + score);
	}
}
