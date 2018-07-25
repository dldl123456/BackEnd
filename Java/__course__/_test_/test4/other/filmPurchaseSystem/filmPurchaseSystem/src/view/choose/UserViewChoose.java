package view.choose;

import java.util.Scanner;

import help.HandleInputMismatchException;
import service.UserService;
import service.impl.UserServiceImpl;
import view.AdminView;
import view.HomePage;
import view.UserView;

public class UserViewChoose {
	Scanner input = new Scanner(System.in);
	UserService us = new UserServiceImpl();
	int choose;//定义一个属性供方法中选择
	public void adminOperateUserPageChoose() throws Exception {
		UserService usi = new UserServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			usi.userFunctionSeeUser();
			break;
		case 2:
			usi.userFunctionSeeAllUser();		
			break;
		case 3:
			usi.userFunctionSeeCityAllUser();
			break;
		case 4:
			usi.userFunctionUpdateBalance();
			break;
		case 5:
			usi.userFunctionResetPassword();
		case 6:
			AdminView.adminMeanPage();		
			break;
		case 7:
			HomePage.homePage();
			break;
		case 8:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateUserPageChoose();
			break;
		}
	}
	public void userFirstPageChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			us.userFunctionLogin();
			break;
		case 2:
			us.userFunctionRegister();
			break;
		case 3:
			us.forgetPassword();
			break;
		case 4:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("是不是傻，让你在1,2,3,4中选，你瞎选啥，有"+choose+"吗？重新选，看准了选，再乱写打死你！！！");
			userFirstPageChoose();
			break;
		}
	}
	
	public void userMeanPageChoose() throws Exception {
		UserService usi = new UserServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			usi.userFunctionSeeRankList();
			break;
		case 2:
			usi.userFunctionSeeMovie();
			break;
		case 3:
			usi.userFunctionBuyTicket(UserView.userNum);
			break;
		case 4:
			usi.userFunctionFilmTicketRefund();
			break;
		case 5:
			usi.userFunctionWriteAssessment();
			break;
		case 6:
			usi.userFunctionUpdatePassword();
			break;
		case 7:
			usi.userFunctionUpdatePhone();
			break;
		case 8:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的指令有误，请重新输入：");
			UserView.userMeanPage();
			break;
		}
	}
	
	public void buyTicketPageChoose() throws Exception{
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			UserView.userbuyTictetPage(UserView.userNum);
			break;
		case 2:
			UserView.userMeanPage();
			break;
		case 3:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的指令有误，请重新输入：");
			System.out.println("【1】、继续购买");
			System.out.println("【2】、返回上一级页面");
			System.out.println("【3】、退出");
			buyTicketPageChoose();
			break;
		}
	}
	public void userForgetPassWord() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			UserView.LoginByPhone();
			break;
		case 2:
			UserView.userCallAdmin();
			break;
		case 3:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("请选择您的操作：\n【1】、使用电话号码验证登录\n【2】、呼叫管理员进行密码重置\n【3】、退出");
			userForgetPassWord();
			break;
		}
	}
}
