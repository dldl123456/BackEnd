/*
 *  用方法比较两个数的大小
 */

package demo.ease.testMax;

public class TestMax {
	//主方法
	public static void main(String[] args) {
		int i = 5;  //第一个数
		int j = 2;  //第二个数
		//调用方法
		int k = max(i, j);
		
		//输出
		System.out.print("最大值是：" + k);
	}
	
	//返回两个整数变量较大的值
	public static int max(int num1, int num2){
		int result = 0;  //用来保存结果
		
		//比较大小
		if(num1>num2){
			result = num1;
		} else {
			result = num2;
		}
		
		//返回结果
		return result;
	}
}
