package entity;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 *  ѧ��ʵ����
 * @author Administrator
 *
 */
public class Student extends Person{
	private double chiness;//���ĳɼ�
	private double math;//��ѧ�ɼ�
	private double english;//Ӣ��ɼ�
	private double sum;//�ܷ�

	public Student() {}
	public Student(int account,String name,String password,
			int age,char sex,String address,
			String hobbys,int loginTimes) {
		super(account,name,password,age,sex,address,hobbys,loginTimes);
	}

	public Student(int account,String name,String 
			password,int age,char sex,String address,
			String hobbys,int loginTimes,double chiness, double math, double english, double sum) {
		super(account,name,password,age,sex,address,hobbys,loginTimes);
		this.chiness = chiness;
		this.math = math;
		this.english = english;
		this.sum = sum;
	}
	public void setAge(int age) {
		while(age>15||age<7) {
			System.out.println("����������䲻�ڹ��ҷ�����Сѧ���䣨7-15����Χ�ڣ����������룺");
			while(true) {
				try {
					age =input.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("������ĸ�ʽ����ȷ������������:");
					 input = new Scanner(System.in);
				}
				break;
			}
		}
		this.age = age;
	}
	public double getChiness() {
		return chiness;
	}

	public void setChiness(double chiness) {
		while(chiness<0||chiness>100) {
			System.out.println("������ĳɼ����Ϸ���Ӧ�ڣ�0-100����Χ�ڣ����������룺");
			while(true) {
				try {
					chiness = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("������ĸ�ʽ����ȷ������������:");
					 input = new Scanner(System.in);
				}
				break;
			}	
		}
		this.chiness = chiness;
	}
	
	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		while(math<0||math>100) {
			System.out.println("������ĳɼ����Ϸ���Ӧ�ڣ�0-100����Χ�ڣ����������룺");			
			while(true) {
				try {
					math = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("������ĸ�ʽ����ȷ������������:");
					 input = new Scanner(System.in);
				}
				break;
			}
		}
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		while(english<0||english>100) {
			System.out.println("������ĳɼ����Ϸ���Ӧ�ڣ�0-100����Χ�ڣ����������룺");
			while(true) {
				try {
					english = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("������ĸ�ʽ����ȷ������������:");
					 input = new Scanner(System.in);
				}
				break;
			}
		}
		this.english = english;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double chiness,double math,double english) {
		this.sum = chiness +math+ english;
	}
	/**
	 * �ж�����״̬
	 * @return
	 */
	private String judgeStatus() {
		if(getLoginTimes()==0) {
			return "����";
		}else {
			return "����";
		}
		
	}
	public String toString() {
		return 	getAccount() + "\t" + getName() + "\t"+ getAge() + 
				"\t" + getSex() + "\t" + getAddress() + "\t" + getHobbys() + "\t" + judgeStatus();
	}
	/**
	 * ����ɼ���toString����
	 */
	public String toString2() {
		return getName() + "\t" +chiness + "\t" +math + "\t" +english + "\t" +sum;
	}
}
