package dao;

import java.util.List;

import entity.Ticket;

/**
 * 
 * @param 给影票类提供数据接口
 * @author zmx2321
 *
 */

public interface TicketDao {
	//查看影票信息
	public List<Ticket> querryTicket();
	
	//添加影票信息
	public int addTicket(Ticket ticket);
	
	//删除影票信息
	public int deleteTicket(int ticket_id);
	
	//根据user_name查询影票信息
	public List<Ticket> queryTicket(String user_name);
}
