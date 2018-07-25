package entity;

import java.util.Scanner;

//所有人类的父类
public class Person {
	private int account;//工号/学号
	private String name;//姓名
	private String password;//密码
	protected int age;//年龄
	private char sex;//性别
	private String address;//家庭住址
	private String hobbys;//爱好
	private int loginTimes;//登陆次数
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
		while(sex!='男'&&sex!='女') {
			System.out.println("对不起，您输入的性别在我国不合法，请重新输入：");
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
