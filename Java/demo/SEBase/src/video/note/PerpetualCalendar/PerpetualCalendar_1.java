/*
	����������һ��==>if������
 */

package video.note.PerpetualCalendar;

import java.util.Scanner;

public class PerpetualCalendar_1 {
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
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			days = 31;
		} else if(month==2) {
			if(isRn){
				days = 29;
			} else {
				days = 28;
			}
		} else if(month==4||month==6||month==9||month==11){
			days = 30;
		} else {
			System.out.println("��������·�����");
		}
		
		System.out.println(year + "��" + month + "�¶�Ӧ������Ϊ" + days);
		
	}
}
