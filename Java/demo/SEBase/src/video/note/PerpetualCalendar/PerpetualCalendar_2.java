/*
	����������һ��==>switch������
 */

package video.note.PerpetualCalendar;

import java.util.Scanner;

public class PerpetualCalendar_2 {
	public static void main(String[] args){
		//�������
		int year;	//�����������
		int month;	//�����������
		int days = 0;	//����ָ���µ�����
		boolean isRn;	//���걣��true,����Ϊfalse
		System.out.println("*****ʹ��������*****");
		
		Scanner in = new Scanner(System.in);
		
		//���������
		System.out.print("�������꣺");
		year = in.nextInt();
		
		System.out.print("�������£�");
		month = in.nextInt();
		
		in.close();
		
		//�ж��Ƿ�Ϊ����
		if((year%400==0)||(year%4==0&&year%100!=0)){
			isRn = true;
		} else {
			isRn = false;
		}
		
		if(isRn){
			System.out.println("����������������");
		} else {
			System.out.println("���������ݲ�������");
		}
		
		//�ж�ÿ�µ�����
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				if(isRn){
					days = 29;
				} else {
					days = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			default:
				System.out.println("��������·�����");
		}
		
		System.out.println(year + "��" + month + "�¶�Ӧ������Ϊ" + days);
		
	}
}
