package entity;

import java.util.Scanner;

//��������ĸ���
public class Person {
	private int account;//����/ѧ��
	private String name;//����
	private String password;//����
	protected int age;//����
	private char sex;//�Ա�
	private String address;//��ͥסַ
	private String hobbys;//����
	private int loginTimes;//��½����
	Scanner input = new Scanner(System.in);
	public Person() {
		
	}
	public Person(int account,String name,String password,int age,
			char sex,String address,String hobbys,int loginTimes) {
		this.account=account;
		this.name=name;
		this.password=password;
		this.age=age;
		this.sex=sex;
		this.address=address;
		this.hobbys=hobbys;
		this.loginTimes = loginTimes;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		while(sex!='��'&&sex!='Ů') {
			System.out.println("�Բ�����������Ա����ҹ����Ϸ������������룺");
			sex = input.next().charAt(0);
		}
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobbys() {
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
}
