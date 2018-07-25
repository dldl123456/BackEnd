package contro;

import java.util.List;

import dao.SeasonDao;
import dao.TicketDao;
import dao.UserDao;
import dao.impl.SeasonDaoImpl;
import dao.impl.TicketDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Season;
import entity.Ticket;
import entity.User;
import service.SeasonService;
import service.TicketService;
import service.UserService;
import service.impl.SeasonServiceImpl;
import service.impl.TicketServiceImpl;
import service.impl.UserServiceImpl;
import util.Help;
import util.Seat;

/**
 * 
 * @param ӰƱ���Ʋ�
 * @author zmx2321
 * 
 */

public class TicketContro {
	static TicketService ticketService = new TicketServiceImpl();
	static TicketDao ticketDao = new TicketDaoImpl();
	
	static UserService userService = new UserServiceImpl();
	static UserDao userDao = new UserDaoImpl();
	
	static SeasonService seasonService = new SeasonServiceImpl();
	static SeasonDao seasonDao = new SeasonDaoImpl();
	
	//��ѯ����ӰƱ
	public static void queryTicket() {
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		if (ticketList.isEmpty()) {
			System.out.println("����ӰƱ��");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("ӰƱ��ţ�" + ticket.getTicket_id() + 
					"\nӰԺ���ƣ�" + ticket.getCinema().getCinema_name() + 
					"\nӰ�����ƣ�" + ticket.getHall().getHall_name() + 
					"\n�û�������" + ticket.getUser().getUser_name() + 
					"\n��Ӱ���ƣ�" + ticket.getMovie().getMovie_name() + 
					"\n��Ӱʱ����" + ticket.getMovie().getMovie_length() +
					"\n��λ��ţ�" + ticket.getTicket_seat_id() +
					"\n��Ӱ�۸�" + ticket.getSeason().getSeason_price() + 
					"\n��ӳʱ�䣺" + ticket.getSeason().getSeason_time() +
					"\n��ӳ��ַ��" + ticket.getCinema().getCinema_address() +
					"\n"
				);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		ticketList.clear();
	}
	
	//���ӰƱ(����)
	public static void addTicket(){
		SeasonContro.querySeason();
		int season_id = Help.getInt("�����볡�α�ţ�");
		System.out.println();
		
		Seat.seat();
		int ticket_seat_id = Help.getInt("��������λ��ţ�");
		System.out.println();
		
		UserContro.queryUsersName();
		int user_id = Help.getInt("�������û���ţ�");
		System.out.println();
		
		Ticket ticket = new Ticket(season_id, ticket_seat_id, user_id);
		
		boolean success = ticketService.addTicket(ticket);
		
		if (success) {
			System.out.println("��ӳɹ���\n");
			queryTicketName();
			
		} else {
			System.out.println("���ʧ�ܣ�\n");
		}
	}
	
	//���ӰƱ(�û�)
	public static void addTicket(int user_id) {
		User user = userDao.queryUser(user_id);
		List<Ticket> ticketList = ticketDao.querryTicket();
		boolean flag = true;
		
		try {
			MovieControl.queryMoviesName();
			int movie_id = Help.getInt("�������Ӱ��ţ�");
			System.out.println();
			
			
			HallContro.queryHall();
			int hall_id = Help.getInt("������Ӱ����ţ�");
			System.out.println();
			
			Season season = seasonDao.querySeason(movie_id, hall_id);
			int season_id = season.getSeason_id();
			
			System.out.println("��������ѡ��ƥ��ĳ���Ϊ��");
			SeasonContro.querrySeason(season_id);
			
			Seat.seat();
			int ticket_seat_id = Help.getInt("��������λ��ţ�");
			for(Ticket ticket : ticketList){
				if (ticket_seat_id == ticket.getTicket_seat_id()) {
					flag = false;
					
					while (!flag) {
						ticket_seat_id = Help.getInt("��ѡ�����λ����ѱ�ѡ��������������λ��ţ�");
						if(ticket_seat_id != ticket.getTicket_seat_id()){
							break;
						}
					}
				}
			}
			System.out.println();
			
			if(user.getUser_balance() < season.getSeason_price()){
				System.out.println("���㣬�޷��������ֵ��");
				return ;
			}
			
			Ticket ticket = new Ticket(season_id, ticket_seat_id, user_id);
			
			boolean success = ticketService.addTicket(ticket);
			
			if (success) {
				user.setUser_balance(user.getUser_balance() - season.getSeason_price());
				UserContro.setupCount(user_id, user.getUser_balance());
				
				System.out.println("����ɹ������Ķ������£�");
				queryTicket(user.getUser_name());
				
				System.out.println("�������Ϊ��" + user.getUser_balance());
			} else {
				System.out.println("����ʧ�ܣ�\n");
			}
		} catch (Exception e) {
			System.out.println("�����ҵ�Ӱ�������ڣ�");
		}
	}
	
	//����idɾ��ӰƱ��Ϣ
	public static void deleteTicket(){
		queryTicketName();
		
		int ticket_id = Help.getInt("��������Ҫɾ����ӰƱ��ţ�");
		
		boolean success = ticketService.deleteTicket(ticket_id);
		
		if(success){
			System.out.println("ӰԺɾ���ɹ���\n");
			queryTicketName();
		}else{
			System.out.println("ӰԺɾ��ʧ�ܣ�\n");
		}
	}
	
	//��ѯӰƱ��Ϣ�ͱ��
	public static void queryTicketName(){
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		if (ticketList.isEmpty()) {
			System.out.println("����ӰƱ��");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("ӰƱ��ţ�" + ticket.getTicket_id() + 
					"\n�û�������" + ticket.getUser().getUser_name() + 
					"\n��Ӱ���ƣ�" + ticket.getMovie().getMovie_name() + 
					"\n"
				);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		ticketList.clear();
	} 
	
	//����user_name��ѯӰƱ��Ϣ
	public static void queryTicket(String user_name){
		List<Ticket> ticketList = ticketDao.queryTicket(user_name);
		
		if (ticketList.isEmpty()) {
			System.out.println("����ӰƱ��");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("ӰƱ��ţ�" + ticket.getTicket_id() + 
					"\nӰԺ���ƣ�" + ticket.getCinema().getCinema_name() + 
					"\nӰ�����ƣ�" + ticket.getHall().getHall_name() + 
					"\n�û�������" + ticket.getUser().getUser_name() + 
					"\n��Ӱ���ƣ�" + ticket.getMovie().getMovie_name() + 
					"\n��Ӱʱ����" + ticket.getMovie().getMovie_length() +
					"\n��λ��ţ�" + ticket.getTicket_seat_id() +
					"\n��Ӱ�۸�" + ticket.getSeason().getSeason_price() + 
					"\n��ӳʱ�䣺" + ticket.getSeason().getSeason_time() +
					"\n��ӳ��ַ��" + ticket.getCinema().getCinema_address() +
					"\n"
				);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		ticketList.clear();
	}
	
	//test
	public static void main(String[] args) {
		//��ѯ����ӰƱ
		queryTicket();
		
		//���ӰƱ
		//addTicket(2);
		
		//ɾ��ӰƱ
		//deleteTicket();
		
		//��ѯӰƱ��Ϣ�ͱ��
		//queryTicketName();
		
		//����user_name��ѯӰƱ��Ϣ
		//queryTicket("����");
	}
}
