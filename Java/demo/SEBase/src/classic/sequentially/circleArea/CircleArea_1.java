/*
 *	��֪Բ�İ뾶Ϊ10����Բ������� 
 */

package classic.sequentially.circleArea;

public class CircleArea_1 {
	public static void main(String[] args) {
		int radius = 10;	//�뾶
		float area = (float)0.0;	//���
			
		//��������������뱣����λ��Ч����
		area = (float)(Math.round(radius*Math.PI*100)*0.01);
		
		//������
		System.out.println("Բ�����Ϊ��" + area);
		
	}
}
