package eg.ease.execepIsNum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IsNum_2 {
	public static void main(String[] args) {
		int num = 0;  //��������һ������
		System.out.print("������һ��������");
		
		do{
			//��Ϊ��γ�����ܳ����쳣��������try�����������
			try{  //���
				Scanner in = new Scanner(System.in);  //��ȡ����
				num = in.nextInt();  //���û�����һ������(����û����벻����������ᱨ��InputMismatchException,������Ҫ�׳��쳣)
				in.close();
				break;
			}catch(InputMismatchException e){
				System.out.print("������Ĳ���������������������");  //��ӡ������Ϣ
			}catch(Exception e){
				System.out.print("������Ĳ���������������������");  //��ӡ������Ϣ
			}
		}while(true);
		
		System.out.println("\n�������" + num + "�����������������");
		System.exit(0);
	}
}
