package view;

import contro.CinemaContro;
import util.Help;

/**
 * 
 * @param ӰԺ����
 * @author zmx2321
 * 
 */

public class CinemaView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	public static void cinemaMune(){
		System.out.println("��ӭ����ӰԺ������棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ��ӰԺ");
			System.out.println("2:���ӰԺ");
			System.out.println("3:ɾ��ӰԺ");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ��ӰԺ��\n");
					CinemaContro.queryCinema();
					break;
				case 2: 
					System.out.println("���ӰԺ��\n");
					CinemaContro.addCinema();
					break;
				case 3: 
					System.out.println("ɾ��ӰԺ��\n");
					CinemaContro.deleteCinema();
					
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
		cinemaMune();
	}
}
