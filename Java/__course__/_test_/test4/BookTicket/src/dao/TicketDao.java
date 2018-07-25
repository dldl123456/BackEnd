package dao;

import java.util.List;

import entity.Ticket;

/**
 * 
 * @param ��ӰƱ���ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface TicketDao {
	//�鿴ӰƱ��Ϣ
	public List<Ticket> querryTicket();
	
	//���ӰƱ��Ϣ
	public int addTicket(Ticket ticket);
	
	//ɾ��ӰƱ��Ϣ
	public int deleteTicket(int ticket_id);
	
	//����user_name��ѯӰƱ��Ϣ
	public List<Ticket> queryTicket(String user_name);
}
