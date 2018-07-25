/*
 * 已知三角形的底边为20，高为10，求其面积。 
 */

package classic.sequentially.triangleArea;

public class AriangleArea_1 {
	public static void main(String[] args){
		int bottom = 20,  //底
			high = 10,  //高
			area = 0;  //面积
			
		//求面积
		area = bottom * high;
		
		//输出面积
		System.out.println("三角形的面积为：" + area);
			
	}
}
