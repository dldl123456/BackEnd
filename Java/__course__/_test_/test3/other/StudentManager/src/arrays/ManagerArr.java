package arrays;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import common.HandleInputMismatchException;
import entity.Manager;
import test.Page;

public class ManagerArr extends Manager {
	public static Manager[] ma = new Manager[2];
	Scanner input = new Scanner(System.in);
	Manager[] ma1;//����һ��������������ԭ���������
	int maIndex=-1;//��������õ�����ʦ�����±�	
	public ManagerArr() {
		
	}
	static{
		ma[0] =new Manager(1,"����","111",28,'��',"����","����","У��",0);
		ma[1] =new Manager(2,"����","222",29,'��',"����","��У����","��������",0);
	}
	/**
	 * �������õ�����������Ϣ
	 */
	public void ergodicMa() {
		for(int j=0;j<ma.length;j++) {
			System.out.println(ma[j].toString());
		}
	}
	/**
	 *ע�����Ա
	 */
	public void addManager() {
		int length = ma.length;
		setAccount(length+1);
		newName();
		setPassword("000000");//��ʼ��������6��0
		System.out.println("���������䣺");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("�������Ա�:");
		setSex(input.next().charAt(0));
		System.out.println("��������סַ��");
		setAddress(input.next());
		System.out.println("�����밮�ã�");
		setHobbys(input.next());
		System.out.println("������ְλ��");
		setPosition(input.next());
		ma1[length] = new Manager(getAccount(),getName(),getPassword(),
				getAge(),getSex(),getAddress(),getHobbys(),getPosition(),getLoginTimes());
		ma = ma1;
		System.out.println("ע��ɹ��������˺�Ϊ"+ma.length);
	}
	/**
	 * ���ұ����������Ƿ���Ҫ��ӵĹ���Ա���������û�У��������ݣ����ù���Ա����
	 * @return
	 */
	private String newName() {
		System.out.println("��������Ҫע���������");
		setName(input.next());
		String name = getName();
		for(int j=0;j<ma.length;j++) {
			if(name.equals(ma[j].getName())) {
				maIndex = j;
				break;
			}
		}
		if(maIndex!=-1) {
			System.out.println("���Ѿ��ǹ���Ա����ֱ�ӵ�¼������");			
		}else {//û�е���������
			ma1 = new Manager[ma.length+1];
			for(int i=0;i<ma.length;i++) {
				ma1[i] = ma[i];
			}
		}
		return name;
	}
	/**
	 * ע������Ա��Ϣ
	 */
	public void deleteMan() {
		int index = LoginTemplet.indexAccount;
		System.out.println("�Ƿ�ע����ǰ�˺ţ�ע����������Ϣ�������,��Ҫע��������:y,����ע������������������ĸ������");
		char choose = input.next().charAt(0);
		switch(choose) {
		case 'y':
			Manager[] ma2 = new Manager[ma.length-1];
			if(index==0) {
				for(int i=1;i<ma.length;i++) {
					ma2[i-1] = ma[i];
				}
			}else {
				for(int i=0;i<index;i++) {
					ma2[i] = ma[i];
				}
				for(int i=index+1;i<ma.length;i++) {
					ma2[i-1] = ma[i];
				}
			}
			ma=ma2;		
			System.out.println("ע���ɹ������ڷ�����ҳ�棺");
			Page.homePage();
			break;
		default:
			break;
		}
		System.out.println("��ѡ����һ��������");
		Page.loginSuccess();
	}
}
