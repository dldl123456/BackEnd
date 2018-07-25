package view.choose;

import java.util.Scanner;

import help.HandleInputMismatchException;
import view.AdminView;
import view.HomePage;
import view.UserView;

/**
 * �����ҳ��ѡ��ķ���
 * @author Administrator
 *
 */
public class PageChoose {
	static Scanner input = new Scanner(System.in);
	static HomePage hp = new HomePage();
	/**
	 * ����choose�������쳣
	 */
	/*private static int chooseInputException() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);//���������쳣
		return choose;
	}*/
	
	/**
	 * ϵͳ��ҳѡ��Ĳ���
	 */
	public static void homeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://�û�
			UserView.userFirstPage();
			break;
		case 2://����Ա
			AdminView.adminFirstPage();
			break;
		case 3://�˳�
			HomePage.exitSystem();
			break;
		default:
			System.out.println("���Ĳ���ɵ��˵��123ΪɶҪ��"+choose+"�����䣺");
			homeChoose();
			break;
		}
	}
	/**
	 * �û���ҳѡ��Ĳ���
	 */
	public static void userHomeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://��¼
			
			break;
		case 2://ע��
			
			break;
		case 3://�˳�
			HomePage.exitSystem();
			break;
		default:
			System.out.println("���Ĳ���ɵ��˵��123ΪɶҪ��"+choose+"�����䣺");
			homeChoose();
			break;
		}
	}
	/**
	 * ����Ա��ҳѡ��Ĳ���
	 */
	public static void AdminHomeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://��¼
			
			break;
		case 2://�˳�
			HomePage.exitSystem();
			break;
		default:
			System.out.println("���Ĳ���ɵ��˵��12ΪɶҪ��"+choose+"�����䣺");
			homeChoose();
			break;
		}
	}
}
