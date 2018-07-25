package view;

import contro.EvaluateContro;
import contro.MovieControl;
import contro.TicketContro;
import contro.UserContro;
import entity.User;
import util.Help;

/**
 * 
 * @param �û�����
 * @author zmx2321
 * 
 */

public class UserView {
	private static boolean flag = true;  //�����ж��Ƿ�����ѭ��
	
	//�û�����
	public static void userMune(User user) {
		System.out.println("��ӭ�����û����棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:��Ʊ");
			System.out.println("2:��Ӱ��ѯ");
			System.out.println("3:��ֵ");
			System.out.println("4:�ҵ�����");
			System.out.println("5:������Ϣ");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("��Ʊ��\n");
					TicketContro.addTicket(user.getUser_id());
					
					break;
				case 2: 
					System.out.println("��Ӱ��ѯ��\n");
					MovieControl.queryMovies();
					
					break;
				case 3: 
					System.out.println("�����ڽ��г�ֵ������\n");
					UserContro.updateAccount(user.getUser_id());
					
					break;
				case 4: 
					System.out.println("�ҵ����ۣ�\n");
					
					MovieControl.queryMoviesName();
					
					EvaluateContro.addEvaluate(user.getUser_id());
					
					EvaluateContro.queryEvaluate();
					
					break;
				case 5: 
					System.out.println("������Ϣ��\n");
					UserContro.PersonalInformation(user.getUser_id());  //user_id
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
	
	//�û��������
	public static void userAdminMune(){
		System.out.println("��ӭ�����û�������棺");
		
		do{
			System.out.println("*********************");
			System.out.println("1:�鿴ȫ���û�");
			System.out.println("2:����û�");
			System.out.println("3:ɾ���û�");
			System.out.println("0:����");
			System.out.println("*********************");
			
			int ops = Help.getInt("\n����������Ҫ�Ĳ�����");
			
			switch (ops){
				case 1:
					System.out.println("�鿴ȫ���û���\n");
					UserContro.queryUsers();
					break;
				case 2: 
					System.out.println("����û���\n");
					UserContro.regist();
					
					break;
				case 3: 
					System.out.println("ɾ���û���\n");
					UserContro.deleteUser();
					
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
		//User user = new User(1);
		
		//userMune(user);
		
		userAdminMune();
	}
}
