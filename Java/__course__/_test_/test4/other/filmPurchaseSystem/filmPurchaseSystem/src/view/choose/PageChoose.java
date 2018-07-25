package view.choose;

import java.util.Scanner;

import help.HandleInputMismatchException;
import view.AdminView;
import view.HomePage;
import view.UserView;

/**
 * 这里放页面选择的方法
 * @author Administrator
 *
 */
public class PageChoose {
	static Scanner input = new Scanner(System.in);
	static HomePage hp = new HomePage();
	/**
	 * 处理choose的输入异常
	 */
	/*private static int chooseInputException() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);//处理输入异常
		return choose;
	}*/
	
	/**
	 * 系统主页选项的操作
	 */
	public static void homeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://用户
			UserView.userFirstPage();
			break;
		case 2://管理员
			AdminView.adminFirstPage();
			break;
		case 3://退出
			HomePage.exitSystem();
			break;
		default:
			System.out.println("你四不四傻，说了123为啥要输"+choose+"重新输：");
			homeChoose();
			break;
		}
	}
	/**
	 * 用户主页选项的操作
	 */
	public static void userHomeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://登录
			
			break;
		case 2://注册
			
			break;
		case 3://退出
			HomePage.exitSystem();
			break;
		default:
			System.out.println("你四不四傻，说了123为啥要输"+choose+"重新输：");
			homeChoose();
			break;
		}
	}
	/**
	 * 管理员主页选项的操作
	 */
	public static void AdminHomeChoose() {
		int choose =0;
		choose=HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1://登录
			
			break;
		case 2://退出
			HomePage.exitSystem();
			break;
		default:
			System.out.println("你四不四傻，说了12为啥要输"+choose+"重新输：");
			homeChoose();
			break;
		}
	}
}
