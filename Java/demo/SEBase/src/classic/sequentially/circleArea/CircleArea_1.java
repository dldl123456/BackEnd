/*
 *	已知圆的半径为10，求圆的面积。 
 */

package classic.sequentially.circleArea;

public class CircleArea_1 {
	public static void main(String[] args) {
		int radius = 10;	//半径
		float area = (float)0.0;	//面积
			
		//求面积并四舍五入保留两位有效数字
		area = (float)(Math.round(radius*Math.PI*100)*0.01);
		
		//输出面积
		System.out.println("圆的面积为：" + area);
		
	}
}
