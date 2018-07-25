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
	
	//显示座位
	public static void seat(){
		//查询ticket对象集合
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		int index = 1; //记录索引
		boolean flag = true;  //判断
		
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
				
				index++; //索引每次加一
				flag = false;
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		seat();
	}
}
