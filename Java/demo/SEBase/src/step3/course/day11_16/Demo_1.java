/*
 *  输出1-100的所有数， 跳过3的倍数和带3的数
 */

package step3.course.day11_16;

public class Demo_1 {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++){
			if(i%3==0 || i%10==3 || i/10==3){
				continue;  //跳过此循环，继续下一次的循环
			}
			System.out.print(i + " ");
		}
	}
}
