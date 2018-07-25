package view.choose;

import help.HandleInputMismatchException;
import service.SeatService;
import service.impl.SeatServiceImpl;
import view.AdminView;
import view.HomePage;

public class SeatChoose {
	SeatService ssi = new SeatServiceImpl();
	int choose;//����һ�����Թ�������ѡ��
	public void adminOperateSeatPageChoose() throws Exception {
		choose =0;
		choose =HandleInputMismatchException.handleInputMismatchException(choose);
		switch(choose) {
		case 1:
			ssi.seatFunctionAdd();
			break;
		case 2:
			System.out.println("��ѡ��ɾ���ķ�ʽ��");
			System.out.println("��1��������idɾ����λ");
			System.out.println("��2���������кź�����ɾ��������λ");
			System.out.println("��3���������кź�����ɾ��������λ");
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
			System.out.println("������ı���������������룺");
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
			System.out.println("������ı���������������룺");
			System.out.println("��1��������idɾ����λ");
			System.out.println("��2���������кź�����ɾ��������λ");
			System.out.println("��3���������кź�����ɾ��������λ");
			seatDeleteChoose();
		}
	}
}
