/*
 *  ������ļӷ������û������������֮��
 *  
 *  5+3+2=151022
 *  9+2+4=183652
 *  8+6+3=482466
 *  5+4+5=202541
 *  7+2+5=��
 */

package demo.ease.plusSpecial;

import java.util.Scanner;

public class PlusSpecial {
	public static void main(String[] args) {
		System.out.println("***********����ļӷ�����***********");
		
		//�������
		int num1 = 0, 
			num2 = 0, 
			num3 = 0;  //���������û������������
		int n = 0;  //���������û���Ҫ����Ĵ���
		int res = 0;  //�������������
		
		String answer = "";  //�������������y/n
		
		boolean isTrue = false;  //�����ж�ִ�д���
		
		Scanner in = new Scanner(System.in);  //��ȡ����
		
		//ѭ�������������
		do{
			System.out.print("��������Ҫ���м��μ��㣺");
			
			n = in.nextInt();  //��ȡ�û�����Ĵ���
			
			System.out.println("���㿪ʼ�ˣ�\n");
			
			for(int i=1; i<=n; i++){
				System.out.println("��" + i + "�μ���");
				
				System.out.print("�������������������ÿո������");
				
				num1 = in.nextInt();
				num2 = in.nextInt();
				num3 = in.nextInt();  //��ȡ�û������������
				
				//�������⹫ʽ������
				res = Integer.parseInt(Integer.toString(num1*num2) + Integer.toString(num1*num3) + Integer.toString((num1*num2)+(num1*num3)-num2));
				
				//���������
				System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + res + "\n");
			}
			
			//���û��ж��Ƿ����ִ��
			System.out.print("�Ƿ�Ҫ�������м���?(y/n)��");
			
			answer = in.next();  //��ȡ�û�����ģ�y/n��
			
			//�ж�
			if (answer.equals("y")){  //��==���Ƚ��������������ֵ���������������ڴ��е��׵�ַ����equals()���Ƚ��ַ������������������Ƿ���ͬ��
				isTrue = true;
			}else{
				isTrue = false;
			}
		}while(isTrue);
		
		//�������
		System.out.println("���������");
		
		in.close();  //�رռ���
	}
}
