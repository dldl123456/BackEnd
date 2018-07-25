/*
 * 从键盘输入三角形的底边及高的长度，求其面积。 
 */

package classic.sequentially.triangleArea;

import java.util.Scanner;

public class AriangleArea_2 {
	public static void main(String[] args) {
		System.out.println("请输入三角形的底边长度和高：");
		
		float bottom = (float)0.0,	//底
			  high = (float)0.0,	//高
			  area = (float)0.0;	//面积
		
		//输入底和高
		Scanner in = new Scanner(System.in);
		bottom = in.nextFloat();
		high = in.nextFloat();
		in.close();
		
		//求面积
		area = bottom * high;
		
		//输出面积
		System.out.println("三角形的面积为：" + area);
	}
}
