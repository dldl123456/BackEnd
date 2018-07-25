/*
 *  求1*3*5*...*19之积。
 */

package classic.loop.quadrature;

public class Quadrature {
	public static void main(String[] args) {
		int res = 1;  //用来保存计算所得的结果
		for(int i=0; i<20; i++){
			if(i%2 != 0){
				res *= i;
			}
		}
		System.out.println("求1*3*5*...*19之积为：" + res);
	}
}
