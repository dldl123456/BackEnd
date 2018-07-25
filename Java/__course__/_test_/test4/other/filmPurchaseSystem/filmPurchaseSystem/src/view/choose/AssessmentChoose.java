package view.choose;

import help.HandleInputMismatchException;
import service.AssessmentService;
import service.impl.AssessmentServiceImpl;
import view.AdminView;
import view.HomePage;

public class AssessmentChoose {
	int choose;//定义一个属性供方法中选择
	public void adminOperateAssessmentPageChoose() throws Exception {
		AssessmentService as = new AssessmentServiceImpl();
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			as.seeAllAssessmentOperate();
			break;
		case 2:
			as.seeSomeMovieAssessmentOperate();		
			break;
		case 3:
			as.seeSomeCinemaMovieAssessmentOperate();
			break;
		case 4:
			as.seeSomeCinemaAssessmentOperate();
			break;
		case 5:
			as.seeSomeUserAssessmentOperate();
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
			adminOperateAssessmentPageChoose();
			break;
		}
	}
}
