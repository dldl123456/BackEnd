/*
 *  ����˵����������͵���һ�� void ������
 *  ���������������һ����Ϊ printGrade �ķ��������ҵ���������ӡ�����ķ�����
 */

package eg.tip.testVoidMethod;

public class TestVoidMethod {
	public static void main(String[] args) {
		//����printGrade����
		printGrade(78.5);
	}
	
	public static void printGrade(double score){
		//�ж�
		//����printGrade������һ��void���ͷ�������������ֵ��
		//һ��void�����ĵ���һ����һ����䡣 ���ԣ�������main�����������������ʽ���á������κ��ԷֺŽ��������һ����
		if(score >= 90){
			System.out.println("A");
		}else if(score >= 80.0){
			System.out.println("B");
		}else if(score >= 70.0){
			System.out.println("C");
		}else if(score >= 60.0){
			System.out.println("D");
		}else{
			System.out.println("F");
		}
	}
}
