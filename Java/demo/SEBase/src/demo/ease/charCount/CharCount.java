/*
 *  ����һ�ַ�����ͳ�Ƴ��������ַ����Լ����ִ����� 
 */

package demo.ease.charCount;

public class CharCount {
	public static void main(String[] args) {
		//������ַ���
		String str="aaabbb";
		//�ָ������
		char[] c=str.toCharArray();
		//����һ����ס�������ı���
		int max=0;
		//����һ������������������ַ�
		char cc = 0;
		//ѭ���Ƚ�
		for(int i=0;i<c.length;i++){
			//����һ���м�ֵ
			int is=0;
			
			for(int j=0;j<c.length-1;j++){
				//�Ƚ��ַ�
				if(c[i]==c[j+1]){
					is++;
				}
				//�Ƚϳ��ִ���������
				if(is>max){
					max=is;
					cc=c[i];
				}
			}
			
		}
		//��ӡ
		System.out.println("���ִ���������"+cc+",����"+max+"��");
	}
}
