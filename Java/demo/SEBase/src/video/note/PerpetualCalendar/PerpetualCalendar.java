/*
	������
 */

package video.note.PerpetualCalendar;

import java.util.Scanner;

public class PerpetualCalendar {
	public static void main(String[] args){
		//�������
		int year;	//�����������
		int month;	//�����������
		int days = 0;	//����ָ���µ�����
		int totalDays = 0;	//�����ܵ�������
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
		
		//�������������
		for(int i=1990; i<year; i++){
			if(i%400==0||(i%4==0&&i%100!=0)){
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		
		//���������·�֮ǰ��������
		for(int i=1; i<=month; i++){
			//�ж�ÿ�µ�����
			switch(i){
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
			
			//�����µ��������浽days�����У���û���ۼӽ�ȥ
			if(i!=month){
				totalDays += days;
			}
		}
		
		//��������ڼ�����ʵ����ǰ����Ʊ��\t�ĸ���
		int beforeDays;
		beforeDays = 1 + totalDays % 7;
		
		if(beforeDays == 7){
			beforeDays = 0;	//���������죬0��\t
		}
		
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		
		//�ȴ�ӡ\t
		for(int i=0; i<beforeDays; i++){
			System.out.print("\t");
		}
		
		for(int i=1; i<days; i++){
			System.out.print(i + "\t");
			//��7������
			if((i+beforeDays)%7 == 0){
				System.out.println();
			}
		}
	}
}
