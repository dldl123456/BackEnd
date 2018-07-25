package util;

import java.util.List;

import dao.TicketDao;
import dao.impl.TicketDaoImpl;
import entity.Ticket;
import service.TicketService;
import service.impl.TicketServiceImpl;

public class Seat {
	static TicketService ticketService = new TicketServiceImpl();
	static TicketDao ticketDao = new TicketDaoImpl();
	
	//��ʾ��λ
	public static void seat(){
		//��ѯticket���󼯺�
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		int index = 1; //��¼����
		boolean flag = true;  //�ж�
		
		for(int i=0; i<5; i++){
			for(int j=0; j<8; j++){
				for(Ticket ticket : ticketList){
					if(index == 1 && index != ticket.getTicket_seat_id()){
						flag = false;
					}
					
					if (index == ticket.getTicket_seat_id()) {
                        flag = true;
                    }
				}
				
				if(flag){
					System.out.print("[X]");
				} else {
					System.out.print("[_]");
				}
				
				index++; //����ÿ�μ�һ
				flag = false;
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		seat();
	}
}
