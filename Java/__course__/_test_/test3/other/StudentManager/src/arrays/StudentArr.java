package arrays;

import java.util.Scanner;

import common.HandleInputMismatchException;
import entity.Student;
import test.Page;

//ѧ�������鼰�������
public class StudentArr extends Student{
	public static Student[] stuu = new Student[15];//��ʼ�������15��ѧ����Ϣ
	Student[] stuu1;//����һ�������飬���ڽ�����ӵ�ѧ����Ϣ
	protected Scanner input = new Scanner(System.in);
	int stuIndex=-1;//���������õ�ѧ�����±�
	public StudentArr() {
		
	}
	//��ʼ����ѧ������
	static{
		stuu[0] = new Student(170101,"��ΰ","000001",9,'��',"��ɽһ��","��ë��",0,89.0,95.0,75.0,259.0);
		stuu[1] = new Student(170102,"����","000002",8,'��',"��ɽ����","����",0,87.0,92.0,90.0,269.0);
		stuu[2] = new Student(170103,"����","000003",9,'Ů',"��ɽ����","����",0,96.0,98.0,82.0,276.0);
		stuu[3] = new Student(170104,"����","000004",9,'��',"��ɽһ��","������",0,92.0,80.0,93.0,265.0);
		stuu[4] = new Student(170105,"�Կ�ط","000005",8,'��',"��ɽһ��","����",0,85.0,70.0,67.0,222.0);
		stuu[5] = new Student(170106,"��˼��","000006",9,'��',"��ɽһ��","ƹ����",0,73.0,95.0,72.0,240.0);
		stuu[6] = new Student(170107,"Ǯ���","000007",9,'��',"��ɽһ��","�����",0,98.0,88.0,78.0,264.0);
		stuu[7] = new Student(170108,"�·�","000008",8,'��',"��ɽһ��","������",0,79.0,89.0,77.0,245.0);
		stuu[8] = new Student(170109,"������","000009",9,'��',"��ɽһ��","���",0,90.0,99.0,89.0,278.0);
		stuu[9] = new Student(170110,"�ŲӲ�","000010",9,'��',"��ɽһ��","����Ϸ",0,87.0,100.0,65.0,252.0);
		stuu[10] = new Student(170111,"������","000011",9,'��',"��ɽһ��","�ܲ�",0,85.0,93.0,79.0,257.0);
		stuu[11] = new Student(170112,"������","000012",8,'Ů',"��ɽһ��","д��ҵ",0,93.0,96.0,85.0,274.0);
		stuu[12] = new Student(170113,"������","000013",9,'��',"��ɽһ��","����",0,91.0,93.0,59.0,243.0);
		stuu[13] = new Student(170114,"�Ƿ�","000014",10,'��',"��ɽһ��","��ɽ",0,93.0,59.0,78.0,230.0);
		stuu[14] = new Student(170115,"Ľ�ݸ�","000015",9,'��',"��ɽһ��","��Ӿ",0,98.0,100.0,93.0,291.0);
	}
	/**
	 * �������鰴�����������±�
	 */
	public int getIndexName(String stuName) {
		for(int i=0;i<stuu.length;i++) {
			if(stuName.equals(stuu[i].getName())) {
				stuIndex=i;
				break;
			}
		}
		return stuIndex;
	}
	/**
	 * ���ĺ���ܷ�
	 * @param index  �����ĵ�ѧ�������±�
	 */
	public void newSum(int index) {
		stuu[index].setSum(stuu[index].getChiness(), stuu[index].getMath(), stuu[index].getEnglish());
	}
	/**
	 * �������ӷ���
	 */
	public void addStu() {
		int length = stuu.length+1;
		setAccount(170100+length);
		newName();
		//Ĭ��������Ϊ6��0
		setPassword("000000");
		System.out.println("���������䣺");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("�������Ա�");
		setSex(input.next().charAt(0));
		System.out.println("�������ַ��");
		setAddress(input.next());
		System.out.println("�����밮�ã�");
		setHobbys(input.next());
		System.out.println("���������ĳɼ���");
		double chiness = 0;
		chiness =HandleInputMismatchException.handleInputMismatchException(chiness);
		setChiness(chiness);
		System.out.println("��������ѧ�ɼ���");
		double math = 0;
		math =HandleInputMismatchException.handleInputMismatchException(math);
		setMath(math);
		System.out.println("������Ӣ��ɼ���");
		double english = 0;
		english =HandleInputMismatchException.handleInputMismatchException(english);
		setEnglish(english);
		setSum(getChiness(),getMath(),getEnglish());
		System.out.println("�ܳɼ�Ϊ��"+getSum());
		stuu1[stuu.length] = new Student(getAccount(),getName(),getPassword(),getAge(),
				getSex(),getAddress(),getHobbys(),getLoginTimes(),getChiness(),getMath(),getEnglish(),getSum());
		stuu = stuu1;
		System.out.println("��ӳɹ���"+getName()+"���˺�Ϊ:"+getAccount());
	}
	private String newName() {
		System.out.println("������Ҫ��ӵ�ѧ��������");
		String stuName = input.next();
		setName(stuName);
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println("��ѧ�������Ѿ����ڣ���ѡ����һ��������");
			System.out.print("��1�����鿴��ѧ����Ϣ\t\t��2�����鿴����ѧ����Ϣ\t\t��3���������������ѧ��\t\t��4����������һ��\n");
			int ch = 0;
			ch =HandleInputMismatchException.handleInputMismatchException(ch);
			switch(ch) {
			case 1:
				sayStuuOfName(stuName);
				break;
			case 2:
				ergodicStuu();
				break;
			case 3:
				addStu();
				break;
			case 4:
				Page.loginSuccess();
				break;
			default:
				System.out.println("�������ָ���������������룺");
				break;
			}
			System.out.println("��ѡ��������һ��������");
			Page.loginSuccess();
		}else {
			//����
			stuu1 =new Student[stuu.length+1];
			for(int i=0;i<stuu.length;i++) {
				stuu1[i] = stuu[i];
			}
		}
		return stuName;
	}
	/**
	 * ɾ��ѧ����Ϣ
	 */
	public void deleteStu() {
		System.out.println("������Ҫע����ѧ��������");
		while(true) {
			String stuName = input.next();
			getIndexName(stuName);
			if(stuIndex!=-1) {
				Student[] stuu2 = new Student[stuu.length-1];
				if(stuIndex==0) {
					for(int i=1;i<stuu.length;i++) {
						stuu2[i-1] = stuu[i];
					}
				}else {
					for(int i=0;i<stuIndex;i++) {
						stuu2[i] = stuu[i];
					}
					for(int i=stuIndex+1;i<stuu.length;i++) {
						stuu2[i-1] = stuu[i];
					}
				}
				stuu=stuu2;
				System.out.println("ɾ���ɹ�����Ϊ��������һ���˵�");
				Page.loginSuccess();
			}else {
				System.out.println("�Բ���ϵͳ��û����Ҫɾ����ѧ������ѡ����һ��������");
				Page.loginSuccess();
			}
		}		
	}
	
	/**
	 * ���������������Ϣ��ȫ����Ϣ��
	 */
	public void ergodicStuu() {
		for(int i=0;i<stuu.length;i++) {
			System.out.println(stuu[i].toString());
		}
	}
	/**
	 * ���������������Ϣ���ɼ���
	 */
	public void ergodicStuuScore() {
		for(int i=0;i<stuu.length;i++) {
			System.out.println(stuu[i].toString2());
		}
	}
	/**
	 * ���������鿴��������
	 */
	public void  sayStuuOfName(String stuName) {	
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println("�˺�\t"+ "����\t"+"����\t"+"�Ա�\t"+"��ͥסַ\t"+"��Ȥ����\t"+"״̬");
			System.out.println(StudentArr.stuu[stuIndex].toString());
		}else {
			System.out.println("�Բ������������������ϵͳ�У����������룺");
			stuName = input.next();
			sayStuuOfName(stuName);
		}
	}
	/**
	 * ������������������Ϣ���ɼ���
	 */
	public void reviseStuuScore(String stuName) {
		getIndexName(stuName);
		if(stuIndex!=-1) {
			System.out.println(stuName+"�ĳɼ����£�");
			System.out.println("����\t���ĳɼ�\t��ѧ�ɼ�\tӢ��ɼ�\t�ܳɼ�");
			System.out.println(stuu[stuIndex].toString2());
			System.out.println("������Ҫ�޸ĵĿ�Ŀ��");
			b:while(true) {
				String subject = input.next();
				switch(subject) {
				case "����":
					System.out.println("������Ҫ�޸ĵķ�����");
					double newChiness = 0;
					newChiness =HandleInputMismatchException.handleInputMismatchException(newChiness);
					stuu[stuIndex].setChiness(newChiness);
					newSum(stuIndex);//�޸��ܷ�
					break;
				case "��ѧ":
					System.out.println("������Ҫ�޸ĵķ�����");
					double newMath = 0;
					newMath =HandleInputMismatchException.handleInputMismatchException(newMath);
					stuu[stuIndex].setMath(newMath);
					newSum(stuIndex);
					break;
				case "Ӣ��":
					System.out.println("������Ҫ�޸ĵķ�����");
					double newEnglish = 0;
					newEnglish =HandleInputMismatchException.handleInputMismatchException(newEnglish);
					stuu[stuIndex].setEnglish(newEnglish);
					newSum(stuIndex);
					break;
				default:
					System.out.println("�Բ���������Ŀ�Ŀ����ȷ�����������룺");
					continue b;
				}
				break;
			}
			System.out.println("�޸ĺ�ĳɼ����£�");
			System.out.println("����\t���ĳɼ�\t��ѧ�ɼ�\tӢ��ɼ�\t�ܳɼ�");
			System.out.println(stuu[stuIndex].toString2());
		}else {
			System.out.println("�Բ������������������ϵͳ�У����������룺");
			stuName = input.next();
			reviseStuuScore(stuName);
		}
	}

}
