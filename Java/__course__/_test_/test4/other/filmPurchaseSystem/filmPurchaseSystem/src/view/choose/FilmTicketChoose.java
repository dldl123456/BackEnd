package view.choose;

import help.HandleInputMismatchException;
import service.FilmTicketService;
import service.impl.FilmTicketServiceImpl;
import view.AdminView;
import view.HomePage;

public class FilmTicketChoose {
	FilmTicketService fts = new FilmTicketServiceImpl();
	int choose;//定义一个属性供方法中选择
	public void adminOperateFilMTicketPageChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			fts.ticketFunctionSeeAll();
			break;
		case 2:
			fts.ticketFunctionSeeMovieAllTicket();	
			break;
		case 3:
			fts.ticketFunctionSeeMovieCinemaAllTicket();
			break;
		case 4:
			fts.ticketFunctionSeeCinemaAllTicket();
			break;
		case 5:
			fts.ticketFunctionSeeUserAllTicket();
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
			adminOperateFilMTicketPageChoose();
			break;
	
		}
	}
}
