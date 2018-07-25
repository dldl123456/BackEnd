/*
 *  用循环程序求10的阶乘
 */

package classic.loop.factorial;

public class Factorial_1 {
	public static void main(String[] args) {
		int res = 1;  //用来保存计算的结果
		for(int i=10; i>0; i--){
			res *= i;
		}
		System.out.println("10！= " + res);
	}
}
