package arrays;

import java.util.Scanner;

import common.HandleInputMismatchException;
import entity.Teacher;
import test.Page;
/**
 * ��ʦ���飬������ʼ���͸����������ݷ���
 * @author Administrator
 *
 */
public class TeacherArr extends Teacher{
	Scanner input = new Scanner(System.in);
	public static Teacher[] tc = new Teacher[2];
	Teacher[] tc1;//����һ�������飬��������ԭ���������
	private int tcIndex = -1;//����õ�����ʦ�����±�
	public TeacherArr() {
		
	}
	static{
		tc[0] =new Teacher(101,"������","111111",28,'Ů',"�Ϻ�","����","������ʦ",0);
		tc[1] =new Teacher(102,"����ѧ","222222",29,'��',"���","����","��ѧ��ʦ",0);
	}
	/**
	 * ���ѧ������
	 */
	public void addTeacher() {
		setAccount(100+tc.length+1);
		newName();
		setPassword("000000");
		System.out.println("���������䣺");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("�������Ա�");
		setSex(input.next().charAt(0));
		System.out.println("��������סַ��");
		setAddress(input.next());
		System.out.println("��������˰��ã�");
		setHobbys(input.next());
		System.out.println("������ְλ��");
		setPosition(input.next());
		tc1[tc.length] = new Teacher(getAccount(),getName(),getPassword(),getAge(),getSex(),getAddress(),getHobbys(),getPosition(),getLoginTimes());
		tc = tc1;
		System.out.println("��ӳɹ�,"+getName()+"��ʦ���˺�Ϊ��"+getAccount());
	}
	/**
	 * ���ұ����������Ƿ���Ҫ��ӵ���ʦ���������û�У��������ݣ�������ʦ����
	 * @return
	 */
	private String newName() {
		System.out.println("��������Ҫע���������");
		setName(input.next());
		String newName =getName();
		for(int j=0;j<tc.length;j++) {
			if(newName.equals(tc[j].getName())) {
				tcIndex = j;
				break;
			}
		}
		if(tcIndex!=-1) {
			System.out.println("����ʦ����ϵͳ�У���ֱ�ӵ�¼������");			
		}else {//û�е���������
			tc1 = new Teacher[tc.length+1];
			for(int i=0;i<tc.length;i++) {
				tc1[i] = tc[i];
			}
		}
		return newName;
	}
	/**
	 * ɾ����ʦ��Ϣ
	 * ���õ��ǽ�ԭ���鱻ɾ��������������ݷֱ�����������У�������ֿ�
	 */
	public void deleteStu() {
		System.out.println("������Ҫע������ʦ������");
		while(true) {
			String tcName = input.next();
			getIndexName(tcName);
			if(tcIndex!=-1) {
				Teacher[] tc2 = new Teacher[tc.length-1];
				if(tcIndex==0) {
					for(int i=1;i<tc.length;i++) {
						tc2[i-1] = tc[i];
					}
				}else {
					for(int i=0;i<tcIndex;i++) {
						tc2[i] = tc[i];
					}
					for(int i=tcIndex+1;i<tc.length;i++) {
						tc2[i-1] = tc[i];
					}
				}
				tc=tc2;
				System.out.println("ɾ���ɹ�����Ϊ��������һ���˵�");
				Page.loginSuccess();
			}else {
				System.out.println("�Բ���ϵͳ��û����Ҫɾ������ʦ���Ѿ���ɾ������ѡ����һ��������");
				Page.loginSuccess();
			}
		}
	}
	/**
	 * ���������������Ϣ��ȫ����Ϣ��
	 */
	public void ergodicTc() {
		for(int i=0;i<tc.length;i++) {
			System.out.println(tc[i].toString());
		}
	}
	/**
	 * �������鰴�����������±�
	 */
	public int getIndexName(String tcName) {
		for(int i=0;i<tc.length;i++) {
			if(tcName.equals(tc[i].getName())) {
				tcIndex=i;
				break;
			}
		}
		return tcIndex;
	}
	/**
	 * ���������鿴��������
	 */
	public void sayTcOfName(String tcName) {
		getIndexName(tcName);
		if(tcIndex!=-1) {
			System.out.println("��������Ҫ�鿴����ʦ��Ϣ��");
			System.out.println("�˺�\t" + "����\t"  +"����\t"  + "�Ա�\t" +"��ַ\t" +"����\t" +"ְλ\t"+"״̬");
			System.out.println(tc[tcIndex].toString());
		}else {
			System.out.println("�Բ�����Ҫ�鿴����ʦ����ϵͳ�У���ѡ����һ��������");
			System.out.print("��1�����鿴������ʦ\t\t��2����ע����ʦ��Ϣ\t\t��3����������һ��\t\t��4�����˳�ϵͳ\n");
			choose();
		}
	}
	/**
	 * ��������������ʦ�����Ĳ���
	 */
	private void choose() {
		/**
		 * ���������쳣
		 */
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			System.out.println("������Ҫ�鿴����ʦ������");	
			String tcName = input.next();
			sayTcOfName(tcName);
			break;
		case 2:
			addTeacher();
			break;
		case 3:
			Page.loginSuccess();
		case 4:
			Page.exit();
		default:
			System.out.println("�������ָ���ȷ�����������룺");
			choose();
		}
	}
}
