/*
 *  ��1*3*5*...*19֮����
 */

package classic.loop.quadrature;

public class Quadrature {
	public static void main(String[] args) {
		int res = 1;  //��������������õĽ��
		for(int i=0; i<20; i++){
			if(i%2 != 0){
				res *= i;
			}
		}
		System.out.println("��1*3*5*...*19֮��Ϊ��" + res);
	}
}
