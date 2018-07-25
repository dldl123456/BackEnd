package view.choose;

import help.HandleInputMismatchException;
import service.SessionService;
import service.impl.SessionServiceImpl;
import view.AdminView;
import view.HomePage;

public class SessionChoose {
	int choose;//定义一个属性供方法中选择
	public void adminOperateSessionPageChoose() throws Exception {
		SessionService ss = new SessionServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			ss.adminFunctionAddSession();
			break;
		case 2:
			ss.adminFunctionDeleteSession();
			break;
		case 3:
			ss.adminFunctionSeeAllSession();
			break;
		case 4:
			ss.adminFunctionSeeCinemaAllSession();
			break;
		case 5:
			ss.adminFunctionSeeMovieAllSession();
			break;
		case 6:
			ss.adminFunctionSeeCinemaMovieAllSession();
			break;
		case 7:
			ss.aadminFunctionSeeSession();
			break;
		case 8:
			AdminView.adminMeanPage();		
			break;
		case 9:
			HomePage.homePage();
			break;
		case 10:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateSessionPageChoose();
			break;
	
		}
	}
}
