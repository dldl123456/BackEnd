package project.StudentMS_2;

import java.util.Scanner;

public class StudentMS_2 {
	static int num;
	static int[] stuId = new int[100];
	static String[] stuName = new String[100];
	static String[] stuSex = new String[100];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// stuId[0] = 1;
		// stuName[0] = "����";
		// stuSex[0] = "��";
		menu();

	}

	private static void menu() {
		System.out.println("---�˵�---");

		System.out.println("1.���ѧ��");
		System.out.println("2.ɾ��ѧ��");
		System.out.println("3.�޸�ѧ��");
		System.out.println("4.��ѯѧ��");

		num = sc.nextInt();
		switch (num) {
		case 1:
			tianjia();
			break;
		case 2:
			shanchu();
			break;
		case 3:
			xiugai();
			break;
		case 4:
			chaxun();
			break;
		default:
			break;
		}
	}

	private static void shanchu() {
		System.out.println("--��������Ҫɾ����ѧ��");
		int id = sc.nextInt();
		if (id < 100) {
			stuId[id - 1] = 0;
			stuName[id - 1] = null;
			stuSex[id - 1] = null;
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("��������ȷѧ�ţ�100���ڣ�");
		}
		menu();
	}

	private static void chaxun() {
		// TODO Auto-generated method stub

		System.out.println("--��ѯѧ��������ѧ��");
		System.out.println("1.---ѧ�Ų�ѯ");
		System.out.println("2.---��ѯ����");
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("������ѧ��");
			int i = sc.nextInt();

			System.out.println("ѧ��:" + stuId[i - 1] + " ����:" + stuName[i - 1] + " �Ա�:" + stuSex[i - 1]);
			menu();
		} else if (num == 2) {
			for (int j = 0; j < stuId.length; j++) {
				System.out.println("ѧ��:" + stuId[j] + " ����:" + stuName[j] + " �Ա�:" + stuSex[j]);
			}
		}
		menu();
	}

	private static void xiugai() {
		// TODO Auto-generated method stub
		System.out.println("--�޸�ѧ����������ѧ��");

		int i = sc.nextInt();
		if (i < stuId.length) {
			System.out.println("�����µ�����");
			String name = sc.next();
			stuName[i - 1] = name;
			System.out.println("�����Ա�");
			String sex = sc.next();
			stuSex[i - 1] = sex;
			System.out.println("�µ���ϢΪ: " + "ѧ��:" + stuId[i - 1] + " ����:" + stuName[i - 1] + " �Ա�:" + stuSex[i - 1]);

		} else {
			System.out.println("����������������ȷѧ�ţ�100���ڣ�");
		}
		menu();
	}

	private static void tianjia() {
		// TODO Auto-generated method stub
		System.out.println("--���ѧ����������ѧ��");

		int id = sc.nextInt();
		if (id < stuId.length) {
			System.out.println("����������");
			String name = sc.next();
			System.out.println("�������Ա�");
			String sex = sc.next();
			stuId[id - 1] = id;
			stuName[id - 1] = name;
			stuSex[id - 1] = sex;

		} else {
			System.out.println("��������ȷ��ѧ�ţ�100���ڣ�");
		}
		menu();
	}

}