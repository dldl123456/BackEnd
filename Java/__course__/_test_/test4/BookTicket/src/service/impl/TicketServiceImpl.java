package service.impl;

import java.util.List;

import dao.TicketDao;
import dao.impl.TicketDaoImpl;
import entity.Ticket;
import service.TicketService;

/**
 * 
 * @param ʵ��ӰƱ����ӿ�
 * @author zmx2321
 * 
 */

public class TicketServiceImpl implements TicketService {
	private static List<Ticket> ticketlist = null;
	private int code = 0;  //sqlִ��״̬
	
	private TicketDao ticketDao;
	
	public TicketServiceImpl() {
		ticketDao = new TicketDaoImpl();
	}
	
	//��ѯ����ӰƱ
	@Override
	public boolean queryTicket() {
		ticketlist = ticketDao.querryTicket();
		
		return ticketlist == null ? false : true;
	}
	
	//���ӰƱ
	@Override
	public boolean addTicket(Ticket ticket) {
		code = ticketDao.addTicket(ticket);
		
		return code == 0 ? false : true;
	}
	
	//ɾ��ӰƱ
	@Override
	public boolean deleteTicket(int ticket_id) {
		code = ticketDao.deleteTicket(ticket_id);
		
		return code == 0 ? false : true;
	}
	
	//����user_name��ѯӰƱ��Ϣ
	@Override
	public boolean queryTicket(String user_name) {
		ticketlist = ticketDao.querryTicket();
		
		return ticketlist == null ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		TicketServiceImpl tsi = new TicketServiceImpl();
		Ticket ticket = new Ticket(1, 16, 1);
		
		//��ѯ����ӰƱ
		System.out.println(tsi.queryTicket());
		
		//���ӰƱ
		System.out.println(tsi.addTicket(ticket));
		
		//ɾ��ӰƱ
		System.out.println(tsi.deleteTicket(2));
		
		//����user_name��ѯӰƱ��Ϣ
		System.out.println(tsi.queryTicket("����"));
	}
}
