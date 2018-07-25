package service;

import entity.Ticket;

/**
 * 
 * @param 给影票服务提供接口
 * @author zmx2321
 *
 */

public interface TicketService {
	//查询所有影票
	public boolean queryTicket();
	
	//添加影票
	public boolean addTicket(Ticket ticket);
	
	//删除影票
	public boolean deleteTicket(int ticket_id);
	
	//根据user_name查询影票信息
	public boolean queryTicket(String user_name);
}
