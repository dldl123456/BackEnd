/*
 *  �÷����Ƚ��������Ĵ�С
 */

package demo.ease.testMax;

public class TestMax {
	//������
	public static void main(String[] args) {
		int i = 5;  //��һ����
		int j = 2;  //�ڶ�����
		//���÷���
		int k = max(i, j);
		
		//���
		System.out.print("���ֵ�ǣ�" + k);
	}
	
	//�����������������ϴ��ֵ
	public static int max(int num1, int num2){
		int result = 0;  //����������
		
		//�Ƚϴ�С
		if(num1>num2){
			result = num1;
		} else {
			result = num2;
		}
		
		//���ؽ��
		return result;
	}
}
