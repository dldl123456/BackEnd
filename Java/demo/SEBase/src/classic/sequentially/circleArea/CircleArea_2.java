/*
 * �Ӽ�������Բ�İ뾶ֵ����Բ������� 
 */

package classic.sequentially.circleArea;

import java.util.Scanner;

public class CircleArea_2 {
	public static void main(String[] args) {
		System.out.print("������Բ�İ뾶��");
		
		float radius = (float)0.0,  //����Բ�İ뾶
			  area = (float)0.0;  //����Բ�����
		
		//����Բ�İ뾶
		Scanner in = new Scanner(System.in);
		radius = in.nextFloat();
		in.close();
		
		//��������������뱣����λ��Ч����
		area = (float) (Math.round(radius*Math.PI*100)*0.01);
		
		//���Բ�����
		System.out.println("Բ�����Ϊ��" + area);
	}
}
