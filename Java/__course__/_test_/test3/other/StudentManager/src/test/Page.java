package test;

import java.util.InputMismatchException;
import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.ManagerArr;
import common.HandleInputMismatchException;
import function.ManagerFunction;
import function.StudentFunction;
import function.TeacherFunction;
import operate.ManagerOperate;
import operate.StudentOperate;
import operate.TeacherOperate;
/**
 * ��ҳ���࣬��������ҳ��
 * @author Administrator
 *
 */
public class Page {
	static Scanner input = new Scanner(System.in);
	public static int choose1;
	/**
	 * ��ҳ��
	 */
	public static void homePage(){
		LoginTemplet.indexPassword=-1;//��ԭ
		LoginTemplet.indexAccount=-1;
		System.out.println("���������������ﻶӭ�������������Сѧѧ������ϵͳ����������������");
		System.out.print("��1������ʦ\t\t��2����ѧ��\t\t��3��������Ա\t��4�����˳�\n");
		System.out.println("�����·����������ݱ�ţ��Խ�����һ��������");
		select();
	}
	/**
	 * ��ʦ��ѧ����ݵĹ�������
	 */
	private static void commonPage1() {
		System.out.println("��ѡ����Ҫ���еĲ�����");	
		System.out.print("��1������¼\t\t��2����������ҳ��\t��3�����˳�\n");
	}
	/**
	 * ����Ա��ݵ�ѡ��
	 */
	private static void commonPage2() {
		System.out.println("��ѡ����Ҫ���еĲ�����");	
		System.out.print("��1������¼\t\t��2����ע��\t\t��3����������ҳ��\t��4�����˳�\n");
	}
	/**
	 * ���ѡ�񷽷�
	 */
	public static void select(){
		while(true) {
			try {
				choose1 = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("������ĸ�ʽ����ȷ������������");
				 input = new Scanner(System.in);
			}
		}	
		switch (choose1){
		case 1:
			System.out.println("��ӭ�����ʦ�������棺");
			choose();
			break;
		case 2:
			System.out.println("��ӭ����ѧ���������棺");
			choose();
			break;
		case 3:
			System.out.println("��ӭ�������Ա�������棺");
			chooseManager();
			break;
		case 4:
			exit();
			break;
		default:
			System.out.println("�������ָ���������������:1����ʦ \t2��ѧ��\t3������Ա\t4���˳�ϵͳ");
			select();
			break;
		}
	}	
	/**
	 * ��ʦ��ѧ����ݵ���һ������
	 */
	private static void choose(){
		commonPage1();
		/**
		 * ���������쳣
		 */
		int choose = 0;
		choose = HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			switch(choose1) {
			case 1:
				LoginTemplet teacherOpe = new TeacherOperate();//��̬
				teacherOpe.Login();
				break;
			case 2:
				LoginTemplet studentOpe = new StudentOperate();//��̬
				studentOpe.Login();
				break;
			default:
				exit();
				break;
			}
			break;
		case 2:
			homePage();
			break;
		case 3:
			System.out.println("ллʹ�ñ�ϵͳ����ӭ���ٴι��٣�����");
			System.exit(0);
			break;
		default:
			System.out.println("�������ָ���������������");
			choose();
			break;
		}
	}
	/**
	 * ����Ա����һ������
	 */
	private static void chooseManager(){
		a:while(true) {
			commonPage2();
			/**
			 * ���������쳣
			 */
			int choose = 0;
			choose = HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				LoginTemplet managerOpe = new ManagerOperate();//��̬
				managerOpe.Login();
				break;
			case 2:
				new ManagerArr() {
					
				}.addManager();
				System.out.println("��Ϊ��������һ���˵�����ѡ������Ҫ�Ĳ�����");
				continue a;
			case 3:
				homePage();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("�������ָ���������������");
				choose();
				break;
			}
			break;
		}
		
	}
	/**
	 * ��¼�ɹ���Ĳ���
	 */
	public static void loginSuccess() {
		int status = Page.choose1;
		switch (status) {
		case 1:
			System.out.print("��1�����鿴����ѧ����Ϣ\t\t��4�����鿴����ѧ���ɼ�\t\t��7����ע��ѧ����Ϣ\t\t��10�����޸��˻�����"+"\n"
					+"��2�����鿴����ѧ����Ϣ\t\t��5�����޸�ѧ���ɼ�\t\t��8�����鿴�˻���Ϣ\t\t��11����������ҳ��"+"\n"
					+"��3�����鿴�ɼ����а�\t\t��6�������ѧ��\t\t��9�����޸��˻���Ϣ\t\t��12�����˳�ϵͳ\n");
			TeacherFunction tf = new TeacherFunction();
			tf.overall();
			break;
		case 2:
			System.out.print("��1�����鿴�˻���Ϣ\t\t��3�����鿴���˳ɼ�\t\t��5�����޸��˻�����\t\t��7�����˳�ϵͳ"+"\n"
					+"��2�����޸��˻���Ϣ\t\t��4�����鿴�ɼ����а�\t\t��6����������ҳ��\n");
			StudentFunction sf = new StudentFunction();
			sf.overall();
			break;
		case 3:
			System.out.print("��1�����鿴���й���Ա��Ϣ\t��4���������ʦ\t\t��7�����޸��˻���Ϣ\t\t��10����������ҳ��"+"\n"
					+"��2�����鿴������ʦ��Ϣ\t\t��5����ע����ʦ�˺���Ϣ\t\t��8�����޸��˻�����\t\t��11�����˳�ϵͳ"+"\n"
					+"��3����������ʦ\t\t��6�����鿴�˻���Ϣ\t\t��9����ע�����˻�\n");
			ManagerFunction mf = new ManagerFunction();
			mf.overall();
			break;
		default:
			System.exit(0);
			break;
		}
	}
	/**
	 * �����˳�����
	 */
	public static void exit() {
		System.out.println("ллʹ�ñ�ϵͳ����ӭ���ٴι��٣�����");
		System.exit(0);
	}
}
