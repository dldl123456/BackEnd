/*
 *  ��ѭ��������10�Ľ׳�
 */

package classic.loop.factorial;

public class Factorial_1 {
	public static void main(String[] args) {
		int res = 1;  //�����������Ľ��
		for(int i=10; i>0; i--){
			res *= i;
		}
		System.out.println("10��= " + res);
	}
}
