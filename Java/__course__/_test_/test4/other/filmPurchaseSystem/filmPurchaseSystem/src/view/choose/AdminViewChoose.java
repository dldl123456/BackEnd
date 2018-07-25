package view.choose;

import java.util.Scanner;

import help.HandleInputMismatchException;
import service.AdminService;
import service.impl.AdminServiceImpl;
import view.HomePage;

public class AdminViewChoose {
	Scanner input = new Scanner(System.in);
	AdminService as = new AdminServiceImpl();
	int choose;//����һ�����Թ�������ѡ��
	
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
			System.out.println("�ǲ���ɵ��������1,2��ѡ����Ϲѡɶ����"+choose+"������ѡ����׼��ѡ������д�����㣡����");
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
			System.out.println("������ı���������������룺");
			adminMeanPageChoose();
			break;
	
		}
	}
	
	
}
