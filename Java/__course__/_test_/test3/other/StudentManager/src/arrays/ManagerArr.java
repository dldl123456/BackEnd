package arrays;

import java.util.Scanner;

import abatractClass.LoginTemplet;
import common.HandleInputMismatchException;
import entity.Manager;
import test.Page;

public class ManagerArr extends Manager {
	public static Manager[] ma = new Manager[2];
	Scanner input = new Scanner(System.in);
	Manager[] ma1;//定义一个数组用来接收原数组的数据
	int maIndex=-1;//用来存放拿到的老师姓名下标	
	public ManagerArr() {
		
	}
	static{
		ma[0] =new Manager(1,"刘鑫","111",28,'男',"西安","打人","校长",0);
		ma[1] =new Manager(2,"王俊","222",29,'男',"村里","被校长打","教务主任",0);
	}
	/**
	 * 遍历并拿到数组所有信息
	 */
	public void ergodicMa() {
		for(int j=0;j<ma.length;j++) {
			System.out.println(ma[j].toString());
		}
	}
	/**
	 *注册管理员
	 */
	public void addManager() {
		int length = ma.length;
		setAccount(length+1);
		newName();
		setPassword("000000");//初始密码设置6个0
		System.out.println("请输入年龄：");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("请输入性别:");
		setSex(input.next().charAt(0));
		System.out.println("请输入现住址：");
		setAddress(input.next());
		System.out.println("请输入爱好：");
		setHobbys(input.next());
		System.out.println("请输入职位：");
		setPosition(input.next());
		ma1[length] = new Manager(getAccount(),getName(),getPassword(),
				getAge(),getSex(),getAddress(),getHobbys(),getPosition(),getLoginTimes());
		ma = ma1;
		System.out.println("注册成功，您的账号为"+ma.length);
	}
	/**
	 * 查找遍历数组中是否有要添加的管理员姓名，如果没有，数组扩容，设置管理员姓名
	 * @return
	 */
	private String newName() {
		System.out.println("请输入需要注册的姓名：");
		setName(input.next());
		String name = getName();
		for(int j=0;j<ma.length;j++) {
			if(name.equals(ma[j].getName())) {
				maIndex = j;
				break;
			}
		}
		if(maIndex!=-1) {
			System.out.println("您已经是管理员，请直接登录！！！");			
		}else {//没有的姓名扩容
			ma1 = new Manager[ma.length+1];
			for(int i=0;i<ma.length;i++) {
				ma1[i] = ma[i];
			}
		}
		return name;
	}
	/**
	 * 注销管理员信息
	 */
	public void deleteMan() {
		int index = LoginTemplet.indexAccount;
		System.out.println("是否注销当前账号，注销后所有信息将会清空,仍要注销请输入:y,若不注销则输入其他任意字母或数字");
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
			System.out.println("注销成功，正在返回主页面：");
			Page.homePage();
			break;
		default:
			break;
		}
		System.out.println("请选择下一步操作：");
		Page.loginSuccess();
	}
}
