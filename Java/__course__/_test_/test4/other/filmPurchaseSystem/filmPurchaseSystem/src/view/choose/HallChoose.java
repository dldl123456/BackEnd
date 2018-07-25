package view.choose;

import help.HandleInputMismatchException;
import service.HallService;
import service.impl.HallServiceImpl;
import view.AdminView;
import view.HomePage;

public class HallChoose {
	int choose;//定义一个属性供方法中选择
	public void adminOperateHallPageChoose() throws Exception {
		HallService hsi = new HallServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			hsi.adminFunctionAddHall();
			break;
		case 2:
			hsi.adminFunctionDeleteHall();
			break;
		case 3:
			hsi.adminFunctionSeeAllHall();
			break;
		case 4:
			hsi.adminFunctionSeeCityAllHall();
			break;
		case 5:
			hsi.aadminFunctionSeeHall();
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
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateHallPageChoose();
			break;
		}
	}
}
