package view;

import contro.TicketContro;
import util.Help;

/**
 * 
 * @param ӰƱ����
 * @author zmx2321
 * 
 */

public class TicketView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	public static void ticketMune(){
		System.out.println("��ӭ���붩��������棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ��ӰƱ");
			System.out.println("2:���ӰƱ");
			System.out.println("3:ɾ��ӰƱ");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ��ӰƱ��\n");
					TicketContro.queryTicket();
					
					break;
				case 2: 
					System.out.println("���ӰƱ��\n");
					TicketContro.addTicket();
					
					break;
				case 3: 
					System.out.println("ɾ��ӰƱ��\n");
					TicketContro.deleteTicket();
					
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
		ticketMune();
	}
}
