/*
 *  求一元二次方程的实数根。 
 */

package classic.sequentially.equation;

import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		System.out.println("***** 求一元二次方程的实数根 *****");
		float a = (float)0.0,  //用来保存二次项系数
			  b = (float)0.0,  //用来保存一次项系数
			  c = (float)0.0;  //用来保存常数项
		
		float delta = (float)0.0;  //用来判断该一元二次方程的实数根的个数
		
		@SuppressWarnings("unused")
		float x = (float)0.0,	//用来保存方程的实数根
			  x1 = (float)0.0,	//用来保存方程的实数根
			  x2 = (float)0.0;	//用来保存方程的实数根
		
		//输入一元二次方程的三个系数
		Scanner in = new Scanner(System.in);
		
		//输入一个二次项系数
		System.out.print("请输入二次项系数(二次项系数大于0)：");
		a = in.nextFloat();
		
		//判断输入的二次项系数是否正确
		while(a<0){
			System.out.println("二次项系数应大于0，请重新输入：");
			a = in.nextFloat();
		}
		
		//输入一个一次项系数
		System.out.print("请输入一次项系数：");
		b = in.nextFloat();
		
		//输入一个常数项
		System.out.print("请输入常数项：");
		c = in.nextFloat();
		
		//关闭输入
		in.close();
		
		//计算delta的值，并四舍五入取两位有效数字
		delta = (float)(Math.round((Math.pow(b,2)-4*a*c)*100)*0.01);
		
		//判断根的个数，并求值
		if(delta>0){
			System.out.println("该方程有两个根：");
			//计算x1和x2的值，并四舍五入取两位有效数字
			x1 = (float)(Math.round(((-b + Math.sqrt(delta))/2*a)*100)*0.01);
			x2 = (float)(Math.round(((-b - Math.sqrt(delta))/2*a)*100)*0.01);
			System.out.println("该方程的两个根分别为：" + x1 + "," + x2);
		} else if (delta==0) {
			System.out.println("该方程只有一个根：");
			//计算x的值，并四舍五入取两位有效数字
			x = (float)(Math.round((-b/2*a)*100)*0.01);
		} else {
			System.out.println("delta小于0，该方程无实数根");
		}
	}
}
