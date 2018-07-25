package view;

import contro.EvaluateContro;
import contro.MovieControl;
import entity.User;
import util.Help;

/**
 * 
 * @param ���۽���
 * @author zmx2321
 * 
 */

public class EvaluateView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	public static void evaluateMune(User user){
		System.out.println("��ӭ�������۹�����棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ������");
			System.out.println("2:�������");
			System.out.println("3:ɾ������");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ�����ۣ�\n");
					EvaluateContro.queryEvaluate();
					
					break;
				case 2: 
					System.out.println("������ۣ�\n");
					
					MovieControl.queryMoviesName();
					EvaluateContro.addEvaluate(user.getUser_id());
					EvaluateContro.queryEvaluate();
					
					break;
				case 3: 
					System.out.println("ɾ�����ۣ�\n");
					EvaluateContro.deleteEvaluate();
					
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
		User user = new User(1);
		
		evaluateMune(user);
	}
}
