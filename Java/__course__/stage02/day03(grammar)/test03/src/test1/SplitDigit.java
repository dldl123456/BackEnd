/*
 *  ��ӡ���12.25�ĸ���λ������
 */

package test1;

public class SplitDigit {
	public static void main(String[] args) {
		int num = (int)(12.25*100);  //ȥ��С���㣬��������������ת��������

		String str = String.valueOf(num);  //������ת�����ַ���
		char[] ch=str.toCharArray();  //���ַ�����������
		
		//��������������ÿո�ָ�
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i]+"  ");
		}
	}
}
