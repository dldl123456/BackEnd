/*
 *  ���1-100���������� ����3�ı����ʹ�3����
 */

package step3.course.day11_16;

public class Demo_1 {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++){
			if(i%3==0 || i%10==3 || i/10==3){
				continue;  //������ѭ����������һ�ε�ѭ��
			}
			System.out.print(i + " ");
		}
	}
}
