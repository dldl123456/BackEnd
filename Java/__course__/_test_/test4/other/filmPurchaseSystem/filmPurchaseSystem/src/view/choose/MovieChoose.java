package view.choose;

import help.HandleInputMismatchException;
import service.MovieService;
import service.impl.MovieServiceImpl;
import view.AdminView;
import view.HomePage;

public class MovieChoose {
	MovieService msi = new MovieServiceImpl();
	int choose;//定义一个属性供方法中选择
	public void adminOperateMoviePageChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			msi.adminFunctionAddMovie();
			break;
		case 2:
			msi.adminFunctionDeleteMovie();		
			break;
		case 3:
			msi.adminFunctionUpdateMovieStatus();
			break;
		case 4:
			msi.adminFunctionUpdateMovieScore();
			break;
		case 5:
			msi.adminFunctionSeeAllMovie();
			break;
		case 6:
			msi.aadminFunctionSeeMovie();
			break;
		case 7:
			AdminView.adminMeanPage();		
			break;
		case 8:
			HomePage.homePage();
			break;
		case 9:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateMoviePageChoose();
			break;
	
		}
	}
}
