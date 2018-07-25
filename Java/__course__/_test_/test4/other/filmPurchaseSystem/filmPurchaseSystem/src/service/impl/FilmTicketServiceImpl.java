package service.impl;

import dao.FilmTicketDao;
import dao.impl.FilmTicketDaoImpl;
import entity.FilmTicket;
import service.FilmTicketService;
import view.AdminView;
import view.FilmTicketView;
import view.SeatView;

public class FilmTicketServiceImpl implements FilmTicketService {
	FilmTicketDao tdi = new FilmTicketDaoImpl();
	FilmTicket ticket = new FilmTicket();
	
	@Override
	public void ticketFunctionAdd(int userId ,int cityId) throws Exception {
		ticket = FilmTicketView.FilmTicketBuyPage(userId, cityId);
		int seatId = ticket.getTicketSeat();
		int i=tdi.addFilmTicket(ticket);
		if(i>0) {
			SeatView.SeatUpdateStatusById(seatId);
			System.out.println(FilmTicketView.ticketToString(ticket));
			System.out.println("��Ϊ����ת���ϼ��б�");
			AdminView.adminOperateFilMTicketPage();
		}else {
			System.out.println("��Ʊʧ�ܣ���Ϊ�������ϼ��б�");
			AdminView.adminOperateFilMTicketPage();
		}
	}

	@Override
	public void ticketFunctionRefund() throws Exception {
		FilmTicketView.FilmTicketRefund();
	}

	/*@Override
	public void ticketFunctionSee() throws Exception {
		FilmTicketView.FilmTicketSeePage();
	}
*/
	@Override
	public void ticketFunctionSeeAll() throws Exception {
		FilmTicketView.FilmTicketSeeAllPage();
	}

	@Override
	public void ticketFunctionSeeCinemaAllTicket() throws Exception {
		FilmTicketView.FilmTicketSeeCinemaAllPage();
	}

	@Override
	public void ticketFunctionSeeMovieAllTicket() throws Exception {
		FilmTicketView.FilmTicketSeeMovieAllPage();
	}

	@Override
	public void ticketFunctionSeeUserAllTicket() throws Exception {
		FilmTicketView.FilmTicketSeeUserAllPage();
	}

	@Override
	public void ticketFunctionSeeMovieCinemaAllTicket() throws Exception {
		FilmTicketView.FilmTicketSeeMovieCinemaAllPage();
	}
}
