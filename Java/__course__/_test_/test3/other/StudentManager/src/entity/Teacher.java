package entity;

import java.util.Scanner;

//��ʦ��
public class Teacher extends Person{
	private String position;//ְλ
	Scanner input = new Scanner(System.in);
	/**
	 * �޲εĹ��췽��
	 */
	public Teacher() {
		
	}
	public Teacher(int account,String name,String 
			password,int age,char sex,String address,
			String hobbys,String position,int loginTimes) {
		super(account,name,password,age,sex,address,hobbys,loginTimes);
		this.position=position;
	}
	public void setAge(int age) {
		while(age>65||age<18) {
			System.out.println("�������䲻�ڹ��ҷ����ϰ����䣨18-65���ڣ����������룺");
			age = input.nextInt();
		}
		this.age = age;
	}
	public void setPosition(String position) {
		this.position=position;
	}
	public String getPosition() {
		return position;
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
		return getAccount() +"\t"+ getName()+"\t"+ getAge()+"\t"+ getSex()+
				"\t"+getAddress()+"\t"+getHobbys()+"\t"+getPosition()+"\t"+judgeStatus();
	}
}
