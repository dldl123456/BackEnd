/*
 * 从键盘输入球体的半径，求其体积和表面积。  
 */

package classic.sequentially.ball;

import java.util.Scanner;

public class Ball {
	public static void main(String[] args) {
		System.out.print("请输入球体的半径：");
		
		float radius = (float)0.0,	//定义球体的半径
			  V = (float)0.0,  //定义球体的体积
			  S = (float)0.0;  //定义球体的表面积
		
		//输入球体的半径
		Scanner in = new Scanner(System.in);
		radius = in.nextFloat();
		in.close();
		
		//计算球体的体积并四舍五入取两位有效数字
		V = (float)(Math.round((4/3)*Math.PI*Math.pow(radius,2)*100)*0.01);
		
		//计算球体的表面积并四舍五入取两位有效数字
		S = (float)(Math.round(4*Math.PI*Math.pow(radius,3)*100)*0.01);
		
		//输出球体的体积和表面积
		System.out.println("该球体的体积为：" + V);
		System.out.println("该球体的表面积为：" + S);
	}
}
