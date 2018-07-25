package view.choose;

import help.HandleInputMismatchException;
import service.CinemaService;
import service.impl.CinemaServiceImpl;
import view.AdminView;
import view.HomePage;

public class CinemaChoose {
	int choose;//����һ�����Թ�������ѡ��
	public void adminOperateCinemaPageChoose() throws Exception {
		CinemaService csi = new CinemaServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			csi.adminFunctionAddCinema();
			break;
		case 2:
			csi.adminFunctionDeleteCinema();	
			break;
		case 3:
			csi.adminFunctionSeeAllCinema();
			break;
		case 4:
			csi.adminFunctionSeeCityAllCinema();
			break;
		case 5:
			csi.aadminFunctionSeeCinema();
			break;
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
			adminOperateCinemaPageChoose();
			break;
		}
	}
}
