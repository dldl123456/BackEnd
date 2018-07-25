package entity;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 *  学生实体类
 * @author Administrator
 *
 */
public class Student extends Person{
	private double chiness;//语文成绩
	private double math;//数学成绩
	private double english;//英语成绩
	private double sum;//总分

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
			System.out.println("您输入的年龄不在国家法定上小学年龄（7-15）范围内，请重新输入：");
			while(true) {
				try {
					age =input.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("您输入的格式不正确，请重新输入:");
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
			System.out.println("您输入的成绩不合法，应在（0-100）范围内，请重新输入：");
			while(true) {
				try {
					chiness = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("您输入的格式不正确，请重新输入:");
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
			System.out.println("您输入的成绩不合法，应在（0-100）范围内，请重新输入：");			
			while(true) {
				try {
					math = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("您输入的格式不正确，请重新输入:");
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
			System.out.println("您输入的成绩不合法，应在（0-100）范围内，请重新输入：");
			while(true) {
				try {
					english = input.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("您输入的格式不正确，请重新输入:");
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
		return 	getAccount() + "\t" + getName() + "\t"+ getAge() + 
				"\t" + getSex() + "\t" + getAddress() + "\t" + getHobbys() + "\t" + judgeStatus();
	}
	/**
	 * 输出成绩的toString方法
	 */
	public String toString2() {
		return getName() + "\t" +chiness + "\t" +math + "\t" +english + "\t" +sum;
	}
}
