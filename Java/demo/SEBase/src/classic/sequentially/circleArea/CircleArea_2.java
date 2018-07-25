/*
 * 从键盘输入圆的半径值，求圆的面积。 
 */

package classic.sequentially.circleArea;

import java.util.Scanner;

public class CircleArea_2 {
	public static void main(String[] args) {
		System.out.print("请输入圆的半径：");
		
		float radius = (float)0.0,  //定义圆的半径
			  area = (float)0.0;  //定义圆的面积
		
		//输入圆的半径
		Scanner in = new Scanner(System.in);
		radius = in.nextFloat();
		in.close();
		
		//求面积并四舍五入保留两位有效数字
		area = (float) (Math.round(radius*Math.PI*100)*0.01);
		
		//输出圆的面积
		System.out.println("圆的面积为：" + area);
	}
}
