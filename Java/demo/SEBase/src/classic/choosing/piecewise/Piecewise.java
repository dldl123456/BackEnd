/*
 *  �Ӽ�������x��ֵ����y��ֵ������� 
 */

package classic.choosing.piecewise;

import java.util.Scanner;

public class Piecewise {
	public static void main(String[] args) {
		System.out.print("������x��ֵ��");
		
		float x = (float)0.0;  //��������x��ֵ
		int y = 0;  //��������y��ֵ
		
		//����x��ֵ
		Scanner in = new Scanner(System.in);
		x = in.nextFloat();
		in.close();
		
		//���������x��y��ֵ
		if(x > 0){
			y = 1;
			System.out.println("y��ֵΪ��" + y);
		}else if(x == 0){
			y = 0;
			System.out.println("y��ֵΪ��" + y);
		} else {
			y = -1;
			System.out.println("y��ֵΪ��" + y);
		}
	}
}
