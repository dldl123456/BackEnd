package day1113;

import java.util.Scanner;

public class Demo_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1��4��7�ϿΣ�2��3��5Ԥϰ��6��Ϣ
		int day = 0;// ����
		String dose = null;// ��ɶ
		Scanner input = new Scanner(System.in);
		System.out.println("please input day:");
		day = input.nextInt();
		switch (day) {//ö�٣�int��char��short��byte��String
		case 1:
		case 4:
		case 7:
			dose = "�Ͽ�";
			break;
		case 2:
		case 3:
		case 5:
			dose = "Ԥϰ";
			break;
		case 6:
			dose = "��Ϣ";
			break;

		default:
			System.out.println("�������");
			break;
		}
//		if (day==1||day==4||day==7) {
//			dose = "�Ͽ�";
//		}else if (day==2||day==3||day==5) {
//			dose = "Ԥϰ";
//		}else if (day==6) {
//			dose = "��Ϣ";
//		}else {
//			System.out.println("�������");
//		}
		System.out.println(dose);
		
	}
	

}
