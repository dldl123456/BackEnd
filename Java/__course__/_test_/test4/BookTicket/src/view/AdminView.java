package view;

import util.Help;

/**
 * 
 * @param ����Ա����
 * @author zmx2321
 * 
 */

public class AdminView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	//����Ա�˵�ѡ��
	public static void adminMune(){
		System.out.println("��ӭ�������Ա���棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:��Ӱ����");
			System.out.println("2:ӰԺ����");
			System.out.println("3:Ӱ������");
			System.out.println("4:���ι���");
			System.out.println("5:��������");
			System.out.println("6:�û�����");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int num = Help.getInt("����������Ҫ��ѡ�");
			switch (num){
				case 1:
					System.out.println("��Ӱ����\n");
					MovieView.movieMune();
					break;
				case 2: 
					System.out.println("ӰԺ����\n");
					CinemaView.cinemaMune();
					break;
				case 3: 
					System.out.println("Ӱ������\n");
					HallView.hallMune();
					break;
				case 4:
					System.out.println("���ι���\n");
					SeasonView.seasonMune();
					break;
				case 5:
					System.out.println("��������\n");
					TicketView.ticketMune();
					break;
				case 6:
					System.out.println("�û�����\n");
					UserView.userAdminMune();
					break;
				case 0:
					System.out.println("����\n");
					flag = false;
					break;
				default:
					System.out.println("�������,û�и�ѡ��\n");
					break;
			}
		} while (flag);
	}
	
	//test
	public static void main(String[] args) {
		AdminView.adminMune();
	}
}
