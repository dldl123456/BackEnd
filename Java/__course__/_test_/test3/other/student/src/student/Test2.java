package student;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		boolean b=false;
		do {
			System.out.println("************���˵�����***************");
			System.out.println("1.�鿴ѧ����Ϣ");
			System.out.println("2.���ѧԱ��Ϣ");
			System.out.println("3.�޸�ѧԱ��Ϣ( ��ܰ��ʾ���޸�����͵�ַŶ)");
			System.out.println("4.ɾ��ѧԱ��Ϣ");
			System.out.println("5.����");
			System.out.println("************************************");
			System.out.println("��ѡ��");
			Scanner scanner=new Scanner(System.in);
			boolean isTrue=scanner.hasNext();
			while (!isTrue) {//�����ַ�����
				int str =  scanner.nextInt();
				System.out.println("���������:"+str+"  ֻ�������ַ�Ŷ��");
				System.out.println("���������룺");
				isTrue=scanner.hasNext();
				
			}
			int a=scanner.nextInt();
			switch (a) {
			case 1:
				b=true;
				System.out.println("1.�鿴ѧ����Ϣ");
				break;
			case 2:
				b=true;
				System.out.println("2.���ѧԱ��Ϣ");
				break;
			case 3:
				b=true;
				System.out.println("3.�޸�ѧԱ��Ϣ( ��ܰ��ʾ���޸�����͵�ַŶ)");
				break;
			case 4:
				b=true;
				System.out.println("4.ɾ��ѧԱ��Ϣ");
				break;
			case 5:
				b=false;
				System.out.println("5.����");
				break;
			}
		} while (b);
		System.out.println("1111");
		
	}
}
