package view.choose;

import help.HandleInputMismatchException;
import service.SeatService;
import service.impl.SeatServiceImpl;
import view.AdminView;
import view.HomePage;

public class SeatChoose {
	SeatService ssi = new SeatServiceImpl();
	int choose;//定义一个属性供方法中选择
	public void adminOperateSeatPageChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			ssi.seatFunctionAdd();
			break;
		case 2:
			System.out.println("请选择删除的方式：");
			System.out.println("【1】、根据id删除座位");
			System.out.println("【2】、根据行号和厅号删除整行座位");
			System.out.println("【3】、根据列号和厅号删除整列座位");
			seatDeleteChoose();
			break;
		case 3:
			ssi.seatFunctionSeeHallAllSeat();
			break;
		case 4:
			ssi.seatFunctionUpdateStatusByHall();
			break;
		case 5:
			AdminView.adminMeanPage();		
			break;
		case 6:
			HomePage.homePage();
			break;
		case 7:
			HomePage.exitSystem();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			adminOperateSeatPageChoose();
			break;
		}
	}
	public void seatDeleteChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			ssi.seatFunctionDeleteById();
			break;
		case 2:
			ssi.seatFunctionDeleteByRowHall();
			break;
		case 3:
			ssi.seatFunctionDeleteByRankHall();
			break;
		default:
			System.out.println("您输入的编号有误，请重新输入：");
			System.out.println("【1】、根据id删除座位");
			System.out.println("【2】、根据行号和厅号删除整行座位");
			System.out.println("【3】、根据列号和厅号删除整列座位");
			seatDeleteChoose();
		}
	}
}
