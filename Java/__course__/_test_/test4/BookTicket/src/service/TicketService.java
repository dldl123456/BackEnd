package service;

import entity.Ticket;

/**
 * 
 * @param ��ӰƱ�����ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface TicketService {
	//��ѯ����ӰƱ
	public boolean queryTicket();
	
	//���ӰƱ
	public boolean addTicket(Ticket ticket);
	
	//ɾ��ӰƱ
	public boolean deleteTicket(int ticket_id);
	
	//����user_name��ѯӰƱ��Ϣ
	public boolean queryTicket(String user_name);
}
