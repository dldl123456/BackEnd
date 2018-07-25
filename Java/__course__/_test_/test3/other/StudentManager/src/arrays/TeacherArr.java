package arrays;

import java.util.Scanner;

import common.HandleInputMismatchException;
import entity.Teacher;
import test.Page;
/**
 * 教师数组，包含初始化和更改数组内容方法
 * @author Administrator
 *
 */
public class TeacherArr extends Teacher{
	Scanner input = new Scanner(System.in);
	public static Teacher[] tc = new Teacher[2];
	Teacher[] tc1;//定义一个新数组，用来接收原数组的数据
	private int tcIndex = -1;//存放拿到的老师姓名下标
	public TeacherArr() {
		
	}
	static{
		tc[0] =new Teacher(101,"张语文","111111",28,'女',"上海","教书","语文老师",0);
		tc[1] =new Teacher(102,"李数学","222222",29,'男',"天津","教书","数学老师",0);
	}
	/**
	 * 添加学生方法
	 */
	public void addTeacher() {
		setAccount(100+tc.length+1);
		newName();
		setPassword("000000");
		System.out.println("请输入年龄：");
		int newAge=0;
		newAge=HandleInputMismatchException.handleInputMismatchException(newAge);
		setAge(newAge);
		System.out.println("请输入性别：");
		setSex(input.next().charAt(0));
		System.out.println("请输入现住址：");
		setAddress(input.next());
		System.out.println("请输入个人爱好：");
		setHobbys(input.next());
		System.out.println("请输入职位：");
		setPosition(input.next());
		tc1[tc.length] = new Teacher(getAccount(),getName(),getPassword(),getAge(),getSex(),getAddress(),getHobbys(),getPosition(),getLoginTimes());
		tc = tc1;
		System.out.println("添加成功,"+getName()+"老师的账号为："+getAccount());
	}
	/**
	 * 查找遍历数组中是否有要添加的老师姓名，如果没有，数组扩容，设置老师姓名
	 * @return
	 */
	private String newName() {
		System.out.println("请输入需要注册的姓名：");
		setName(input.next());
		String newName =getName();
		for(int j=0;j<tc.length;j++) {
			if(newName.equals(tc[j].getName())) {
				tcIndex = j;
				break;
			}
		}
		if(tcIndex!=-1) {
			System.out.println("该老师已在系统中，请直接登录！！！");			
		}else {//没有的姓名扩容
			tc1 = new Teacher[tc.length+1];
			for(int i=0;i<tc.length;i++) {
				tc1[i] = tc[i];
			}
		}
		return newName;
	}
	/**
	 * 删除老师信息
	 * 采用的是将原数组被删除数据两侧的数据分别存入新数组中，避免出现空
	 */
	public void deleteStu() {
		System.out.println("请输入要注销的老师姓名：");
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
				System.out.println("删除成功，已为您返回上一级菜单");
				Page.loginSuccess();
			}else {
				System.out.println("对不起，系统中没有您要删除的老师或已经被删除，请选择下一步操作：");
				Page.loginSuccess();
			}
		}
	}
	/**
	 * 遍历并输出数组信息（全部信息）
	 */
	public void ergodicTc() {
		for(int i=0;i<tc.length;i++) {
			System.out.println(tc[i].toString());
		}
	}
	/**
	 * 遍历数组按照姓名查找下标
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
	 * 根据姓名查看数组内容
	 */
	public void sayTcOfName(String tcName) {
		getIndexName(tcName);
		if(tcIndex!=-1) {
			System.out.println("下面是您要查看的老师信息：");
			System.out.println("账号\t" + "姓名\t"  +"年龄\t"  + "性别\t" +"地址\t" +"爱好\t" +"职位\t"+"状态");
			System.out.println(tc[tcIndex].toString());
		}else {
			System.out.println("对不起，您要查看的老师不在系统中，请选择下一步操作：");
			System.out.print("【1】、查看其它老师\t\t【2】、注册老师信息\t\t【3】、返回上一步\t\t【4】、退出系统\n");
			choose();
		}
	}
	/**
	 * 根据姓名查找老师出错后的操作
	 */
	private void choose() {
		/**
		 * 处理输入异常
		 */
		int choose = 0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			System.out.println("请输入要查看的老师姓名：");	
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
			System.out.println("你输入的指令不正确，请重新输入：");
			choose();
		}
	}
}
