package view;

import contro.SeasonContro;
import util.Help;

/**
 * 
 * @param ���ν���
 * @author zmx2321
 * 
 */

public class SeasonView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	public static void seasonMune(){
		System.out.println("��ӭ���볡�ι�����棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ������");
			System.out.println("2:��ӳ���");
			System.out.println("3:ɾ������");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ�����Σ�\n");
					SeasonContro.querySeason();
					
					break;
				case 2: 
					System.out.println("��ӳ��Σ�\n");
					SeasonContro.addSeason();
					
					break;
				case 3: 
					System.out.println("ɾ�����Σ�\n");
					SeasonContro.deleteSeason();
					
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
		seasonMune();
	}
}
