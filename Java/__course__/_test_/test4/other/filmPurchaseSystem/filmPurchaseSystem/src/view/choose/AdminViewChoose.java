package view.choose;

import java.util.Scanner;

import help.HandleInputMismatchException;
import service.AdminService;
import service.impl.AdminServiceImpl;
import view.HomePage;

public class AdminViewChoose {
	Scanner input = new Scanner(System.in);
	AdminService as = new AdminServiceImpl();
	int choose;//定义一个属性供方法中选择
	
	public void adminFirstPageChoose() {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			try {
				as.adminFunctionLogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			HomePage.exitSystem();
		default:
			System.out.println("是不是傻，让你在1,2中选，你瞎选啥，有"+choose+"吗？重新选，看准了选，再乱写打死你！！！");
			adminFirstPageChoose();
		}
	}
	
	public void adminMeanPageChoose() throws Exception {
		AdminService asi = new AdminServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			asi.adminFunctionsuperviseUser();
			break;
		case 2:
			asi.adminFunctionsuperviseFilmTicket();
			break;
		case 3:
			asi.adminFunctionsuperviseMovie();
			break;
		case 4:
			asi.adminFunctionsuperviseCinmea();
			break;
		case 5:
			asi.adminFunctionsuperviseHall();
			break;
		case 6:
			asi.adminFunctionsuperviseSeat();
			break;
		case 7:
			asi.adminFunctionsuperviseSession();
			break;
		case 8:
			asi.adminFunctionsuperviseAssessment();
			break;
		case 9:
			asi.adminFunctionsuperviseCity();
			break;
		case 10:
			HomePage.homePage();
			break;
		case 11:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminMeanPageChoose();
			break;
	
		}
	}
	
	
}
