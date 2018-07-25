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
	int choose;//����һ�����Թ�������ѡ��
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
			System.out.println("������ı���������������룺");
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
			System.out.println("�ǲ���ɵ��������1,2,3,4��ѡ����Ϲѡɶ����"+choose+"������ѡ����׼��ѡ������д�����㣡����");
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
			System.out.println("�������ָ���������������룺");
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
			System.out.println("�������ָ���������������룺");
			System.out.println("��1������������");
			System.out.println("��2����������һ��ҳ��");
			System.out.println("��3�����˳�");
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
			System.out.println("��ѡ�����Ĳ�����\n��1����ʹ�õ绰������֤��¼\n��2�������й���Ա������������\n��3�����˳�");
			userForgetPassWord();
			break;
		}
	}
}
