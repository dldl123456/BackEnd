package common;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import entity.Person;
import test.Page;

/**
 * �޸���Ϣ��ͨ����
 * @author Administrator
 *
 */
public class ReviseMessage {
	static Scanner input = new Scanner(System.in);
	static int index = LoginTemplet.indexAccount;
	/**
	 * �޸ĵ�ǰ�˻�����Ϣ
	 */
	public static void reviseMa(Person [] pe) {
		/**
		 * ���������쳣
		 */
		int cho = 0;
		cho =HandleInputMismatchException.handleInputMismatchException(cho);
		switch(cho) {
		case 1:
			System.out.println("��������Ҫ�޸ĵ����䣺");
			int newAge=0;
			newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
			pe[index].setAge(newAge);
			System.out.println("�����Ѿ��޸ģ��޸ĺ����Ϣ����");
			assist(pe);
			break;
		case 2:
			System.out.println("��������Ҫ�޸ĵĵ�ַ��");
			pe[index].setAddress(input.next());
			System.out.println("��ַ�Ѿ��޸ģ��޸ĺ����Ϣ����");
			assist(pe);
			break;
		case 3:
			System.out.println("��������Ҫ�޸ĵİ��ã�");
			pe[index].setHobbys(input.next());
			System.out.println("�����Ѿ��޸ģ��޸ĺ����Ϣ����");
			assist(pe);
			break;
		default:
			System.out.println("�������ָ��������������룺");
			System.out.println("������Ҫ�޸ĵ�ѡ�[1]������\t[2]����ַ\t\t[3]������");
			/**
			 * ���������쳣
			 */
			int choose = 0;
			choose =HandleInputMismatchException.handleInputMismatchException(choose);
			reviseMa(pe);
		}
		System.out.println("��ѡ����һ��������");
		Page.loginSuccess();
	}
	/**
	 * ��������
	 */
	private static void assist(Person [] pe){
		if(Page.choose1==2) {
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t"+"״̬");
		}else {
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t" +"ְλ\t"+"״̬");
		}
		System.out.println(pe[index]);
	}
}
