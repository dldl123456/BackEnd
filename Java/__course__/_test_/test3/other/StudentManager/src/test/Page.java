package test;

import java.util.InputMismatchException;
import java.util.Scanner;

import abatractClass.LoginTemplet;
import arrays.ManagerArr;
import common.HandleInputMismatchException;
import function.ManagerFunction;
import function.StudentFunction;
import function.TeacherFunction;
import operate.ManagerOperate;
import operate.StudentOperate;
import operate.TeacherOperate;
/**
 * 主页面类，包含各种页面
 * @author Administrator
 *
 */
public class Page {
	static Scanner input = new Scanner(System.in);
	public static int choose1;
	/**
	 * 主页面
	 */
	public static void homePage(){
		LoginTemplet.indexPassword=-1;//还原
		LoginTemplet.indexAccount=-1;
		System.out.println("★★★★★★★★★★★★★★★欢迎进入宇宙最聪明小学学生管理系统★★★★★★★★★★★★★★★");
		System.out.print("【1】、老师\t\t【2】、学生\t\t【3】、管理员\t【4】、退出\n");
		System.out.println("请在下方输入你的身份编号，以进行下一步操作：");
		select();
	}
	/**
	 * 老师和学生身份的公共代码
	 */
	private static void commonPage1() {
		System.out.println("请选择你要进行的操作：");	
		System.out.print("【1】、登录\t\t【2】、返回主页面\t【3】、退出\n");
	}
	/**
	 * 管理员身份的选择
	 */
	private static void commonPage2() {
		System.out.println("请选择你要进行的操作：");	
		System.out.print("【1】、登录\t\t【2】、注册\t\t【3】、返回主页面\t【4】、退出\n");
	}
	/**
	 * 身份选择方法
	 */
	public static void select(){
		while(true) {
			try {
				choose1 = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("您输入的格式不正确，请重新输入");
				 input = new Scanner(System.in);
			}
		}	
		switch (choose1){
		case 1:
			System.out.println("欢迎进入教师操作界面：");
			choose();
			break;
		case 2:
			System.out.println("欢迎进入学生操作界面：");
			choose();
			break;
		case 3:
			System.out.println("欢迎进入管理员操作界面：");
			chooseManager();
			break;
		case 4:
			exit();
			break;
		default:
			System.out.println("你输入的指令错误，请重新输入:1、老师 \t2、学生\t3、管理员\t4、退出系统");
			select();
			break;
		}
	}	
	/**
	 * 教师和学生身份的下一步操作
	 */
	private static void choose(){
		commonPage1();
		/**
		 * 处理输入异常
		 */
		int choose = 0;
		choose = HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			switch(choose1) {
			case 1:
				LoginTemplet teacherOpe = new TeacherOperate();//多态
				teacherOpe.Login();
				break;
			case 2:
				LoginTemplet studentOpe = new StudentOperate();//多态
				studentOpe.Login();
				break;
			default:
				exit();
				break;
			}
			break;
		case 2:
			homePage();
			break;
		case 3:
			System.out.println("谢谢使用本系统，欢迎您再次光临！！！");
			System.exit(0);
			break;
		default:
			System.out.println("你输入的指令错误，请重新输入");
			choose();
			break;
		}
	}
	/**
	 * 管理员的下一步操作
	 */
	private static void chooseManager(){
		a:while(true) {
			commonPage2();
			/**
			 * 处理输入异常
			 */
			int choose = 0;
			choose = HandleInputMismatchException.handleInputMismatchException(choose);
			switch(choose) {
			case 1:
				LoginTemplet managerOpe = new ManagerOperate();//多态
				managerOpe.Login();
				break;
			case 2:
				new ManagerArr() {
					
				}.addManager();
				System.out.println("已为您返回上一级菜单，请选择您需要的操作：");
				continue a;
			case 3:
				homePage();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("你输入的指令错误，请重新输入");
				choose();
				break;
			}
			break;
		}
		
	}
	/**
	 * 登录成功后的操作
	 */
	public static void loginSuccess() {
		int status = Page.choose1;
		switch (status) {
		case 1:
			System.out.print("【1】、查看所有学生信息\t\t【4】、查看所有学生成绩\t\t【7】、注销学生信息\t\t【10】、修改账户密码"+"\n"
					+"【2】、查看单个学生信息\t\t【5】、修改学生成绩\t\t【8】、查看账户信息\t\t【11】、返回主页面"+"\n"
					+"【3】、查看成绩排行榜\t\t【6】、添加学生\t\t【9】、修改账户信息\t\t【12】、退出系统\n");
			TeacherFunction tf = new TeacherFunction();
			tf.overall();
			break;
		case 2:
			System.out.print("【1】、查看账户信息\t\t【3】、查看个人成绩\t\t【5】、修改账户密码\t\t【7】、退出系统"+"\n"
					+"【2】、修改账户信息\t\t【4】、查看成绩排行榜\t\t【6】、返回主页面\n");
			StudentFunction sf = new StudentFunction();
			sf.overall();
			break;
		case 3:
			System.out.print("【1】、查看所有管理员信息\t【4】、添加老师\t\t【7】、修改账户信息\t\t【10】、返回主页面"+"\n"
					+"【2】、查看所有老师信息\t\t【5】、注销老师账号信息\t\t【8】、修改账户密码\t\t【11】、退出系统"+"\n"
					+"【3】、查找老师\t\t【6】、查看账户信息\t\t【9】、注销此账户\n");
			ManagerFunction mf = new ManagerFunction();
			mf.overall();
			break;
		default:
			System.exit(0);
			break;
		}
	}
	/**
	 * 公用退出方法
	 */
	public static void exit() {
		System.out.println("谢谢使用本系统，欢迎您再次光临！！！");
		System.exit(0);
	}
}
