package view;

import contro.HallContro;
import util.Help;

/**
 * 
 * @param Ӱ������
 * @author zmx2321
 * 
 */

public class HallView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	public static void hallMune(){
		System.out.println("��ӭ����Ӱ��������棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ��Ӱ��");
			System.out.println("2:���Ӱ��");
			System.out.println("3:ɾ��Ӱ��");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ��Ӱ����\n");
					HallContro.queryHall();
					
					break;
				case 2: 
					System.out.println("���Ӱ����\n");
					HallContro.addHall();
					
					break;
				case 3: 
					System.out.println("ɾ��Ӱ����\n");
					HallContro.deleteHall();
					
					break;
				case 0:
					System.out.println("����\n");
					flag = false;
					
					break;
				default:
					System.out.println("�������,û�и�ѡ��\n");
					
					break;
			}
		}while(flag);
	}
	
	//test
	public static void main(String[] args) {
		hallMune();
	}
}
