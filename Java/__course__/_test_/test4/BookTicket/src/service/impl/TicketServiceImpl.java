package service.impl;

import java.util.List;

import dao.TicketDao;
import dao.impl.TicketDaoImpl;
import entity.Ticket;
import service.TicketService;

/**
 * 
 * @param 实现影票服务接口
 * @author zmx2321
 * 
 */

public class TicketServiceImpl implements TicketService {
	private static List<Ticket> ticketlist = null;
	private int code = 0;  //sql执行状态
	
	private TicketDao ticketDao;
	
	public TicketServiceImpl() {
		ticketDao = new TicketDaoImpl();
	}
	
	//查询所有影票
	@Override
	public boolean queryTicket() {
		ticketlist = ticketDao.querryTicket();
		
		return ticketlist == null ? false : true;
	}
	
	//添加影票
	@Override
	public boolean addTicket(Ticket ticket) {
		code = ticketDao.addTicket(ticket);
		
		return code == 0 ? false : true;
	}
	
	//删除影票
	@Override
	public boolean deleteTicket(int ticket_id) {
		code = ticketDao.deleteTicket(ticket_id);
		
		return code == 0 ? false : true;
	}
	
	//根据user_name查询影票信息
	@Override
	public boolean queryTicket(String user_name) {
		ticketlist = ticketDao.querryTicket();
		
		return ticketlist == null ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		TicketServiceImpl tsi = new TicketServiceImpl();
		Ticket ticket = new Ticket(1, 16, 1);
		
		//查询所有影票
		System.out.println(tsi.queryTicket());
		
		//添加影票
		System.out.println(tsi.addTicket(ticket));
		
		//删除影票
		System.out.println(tsi.deleteTicket(2));
		
		//根据user_name查询影票信息
		System.out.println(tsi.queryTicket("张三"));
	}
}
