/*
 *  从键盘输入x的值，求y的值并输出。 
 */

package classic.choosing.piecewise;

import java.util.Scanner;

public class Piecewise {
	public static void main(String[] args) {
		System.out.print("请输入x的值：");
		
		float x = (float)0.0;  //用来保存x的值
		int y = 0;  //用来保存y的值
		
		//输入x的值
		Scanner in = new Scanner(System.in);
		x = in.nextFloat();
		in.close();
		
		//根据输入的x求y的值
		if(x > 0){
			y = 1;
			System.out.println("y的值为：" + y);
		}else if(x == 0){
			y = 0;
			System.out.println("y的值为：" + y);
		} else {
			y = -1;
			System.out.println("y的值为：" + y);
		}
	}
}
