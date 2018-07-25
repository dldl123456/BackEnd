package view.choose;

import help.HandleInputMismatchException;
import service.CityService;
import service.impl.CityServiceImpl;
import view.AdminView;
import view.HomePage;

public class CityChoose {
	int choose;//定义一个属性供方法中选择
	public void adminOperateCityPageChoose() throws Exception {
		CityService cs = new CityServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			cs.adminFunctionAddCity();
			break;
		case 2:
			cs.adminFunctionSeeAllCity();	
			break;
		case 3:
			AdminView.adminMeanPage();		
			break;
		case 4:
			HomePage.homePage();
			break;
		case 5:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateCityPageChoose();
			break;
		}
	}
}
