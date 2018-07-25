package service.impl;

import dao.SeatDao;
import dao.impl.SeatDaoImpl;
import entity.Seat;
import service.SeatService;
import view.AdminView;
import view.SeatView;

public class SeatServiceImpl implements SeatService {
	Seat seat = new Seat();
	SeatDao sdi = new SeatDaoImpl();
	@Override
	public void seatFunctionAdd() throws Exception {
		seat = SeatView.SeatAddPage();
		int i=sdi.addSeat(seat);
		if(i>0) {
			System.out.println("��ӳɹ���");
			System.out.println("��ѡ������������");
			AdminView.adminOperateSeatPage();
		}else {
			System.out.println("���ʧ�ܣ�");
			AdminView.adminOperateSeatPage();
		}
	}

	@Override
	public void seatFunctionDeleteById() throws Exception {
		int i=sdi.deleteSeatById(SeatView.SeatDeleteByIdPage());
		if(i>0) {
			System.out.println("ɾ���ɹ���");
			System.out.println("��ѡ������������");
			AdminView.adminOperateSeatPage();
		}else {
			System.out.println("ɾ��ʧ�ܣ�");
			AdminView.adminOperateSeatPage();
		}
	}

	@Override
	public void seatFunctionDeleteByRowHall() throws Exception {
		int i=SeatView.SeatDeleteByRowPage();
		if(i>0) {
			System.out.println("ɾ���ɹ���");
			System.out.println("��ѡ������������");
			AdminView.adminOperateSeatPage();
		}else {
			System.out.println("ɾ��ʧ�ܣ�");
			AdminView.adminOperateSeatPage();
		}
	}

	@Override
	public void seatFunctionDeleteByRankHall() throws Exception {
		int i=SeatView.SeatDeleteByRankPage();
		if(i>0) {
			System.out.println("ɾ���ɹ���");
			System.out.println("��ѡ������������");
			AdminView.adminOperateSeatPage();
		}else {
			System.out.println("ɾ��ʧ�ܣ�");
			AdminView.adminOperateSeatPage();
		}
	}

	@Override
	public void seatFunctionUpdateStatusById(int seatId) throws Exception {
		SeatView.SeatUpdateStatusById(seatId);
	}

	@Override
	public void seatFunctionUpdateStatusByHall() throws Exception {
		SeatView.SeatUpdateStatusByHall();
	}

	@Override
	public void seatFunctionSeeAll() throws Exception {
		SeatView.SeatSeeAllPage();
	}

	@Override
	public void seatFunctionSeeHallAllSeat() throws Exception {
		SeatView.SeatSeeHallAllPage();
	}

}
