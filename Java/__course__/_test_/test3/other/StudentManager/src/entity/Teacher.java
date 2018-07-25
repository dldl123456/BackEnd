package entity;

import java.util.Scanner;

//教师类
public class Teacher extends Person{
	private String position;//职位
	Scanner input = new Scanner(System.in);
	/**
	 * 无参的构造方法
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
			System.out.println("您的年龄不在国家法定上班年龄（18-65）内，请重新输入：");
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
	 * 判断在线状态
	 * @return
	 */
	private String judgeStatus() {
		if(getLoginTimes()==0) {
			return "离线";
		}else {
			return "在线";
		}
		
	}
	public String toString() {
		return getAccount() +"\t"+ getName()+"\t"+ getAge()+"\t"+ getSex()+
				"\t"+getAddress()+"\t"+getHobbys()+"\t"+getPosition()+"\t"+judgeStatus();
	}
}
