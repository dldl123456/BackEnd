/*
 * �Ӽ������������εĵױ߼��ߵĳ��ȣ���������� 
 */

package classic.sequentially.triangleArea;

import java.util.Scanner;

public class AriangleArea_2 {
	public static void main(String[] args) {
		System.out.println("�����������εĵױ߳��Ⱥ͸ߣ�");
		
		float bottom = (float)0.0,	//��
			  high = (float)0.0,	//��
			  area = (float)0.0;	//���
		
		//����׺͸�
		Scanner in = new Scanner(System.in);
		bottom = in.nextFloat();
		high = in.nextFloat();
		in.close();
		
		//�����
		area = bottom * high;
		
		//������
		System.out.println("�����ε����Ϊ��" + area);
	}
}
