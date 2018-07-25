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
 * @param 影票控制层
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
	
	//查询所有影票
	public static void queryTicket() {
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		if (ticketList.isEmpty()) {
			System.out.println("暂无影票！");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("影票编号：" + ticket.getTicket_id() + 
					"\n影院名称：" + ticket.getCinema().getCinema_name() + 
					"\n影厅名称：" + ticket.getHall().getHall_name() + 
					"\n用户姓名：" + ticket.getUser().getUser_name() + 
					"\n电影名称：" + ticket.getMovie().getMovie_name() + 
					"\n电影时长：" + ticket.getMovie().getMovie_length() +
					"\n座位编号：" + ticket.getTicket_seat_id() +
					"\n电影价格：" + ticket.getSeason().getSeason_price() + 
					"\n放映时间：" + ticket.getSeason().getSeason_time() +
					"\n放映地址：" + ticket.getCinema().getCinema_address() +
					"\n"
				);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		ticketList.clear();
	}
	
	//添加影票(管理)
	public static void addTicket(){
		SeasonContro.querySeason();
		int season_id = Help.getInt("请输入场次编号：");
		System.out.println();
		
		Seat.seat();
		int ticket_seat_id = Help.getInt("请输入座位编号：");
		System.out.println();
		
		UserContro.queryUsersName();
		int user_id = Help.getInt("请输入用户编号：");
		System.out.println();
		
		Ticket ticket = new Ticket(season_id, ticket_seat_id, user_id);
		
		boolean success = ticketService.addTicket(ticket);
		
		if (success) {
			System.out.println("添加成功！\n");
			queryTicketName();
			
		} else {
			System.out.println("添加失败！\n");
		}
	}
	
	//添加影票(用户)
	public static void addTicket(int user_id) {
		User user = userDao.queryUser(user_id);
		List<Ticket> ticketList = ticketDao.querryTicket();
		boolean flag = true;
		
		try {
			MovieControl.queryMoviesName();
			int movie_id = Help.getInt("请输入电影编号：");
			System.out.println();
			
			
			HallContro.queryHall();
			int hall_id = Help.getInt("请输入影厅编号：");
			System.out.println();
			
			Season season = seasonDao.querySeason(movie_id, hall_id);
			int season_id = season.getSeason_id();
			
			System.out.println("根据您的选择匹配的场次为：");
			SeasonContro.querrySeason(season_id);
			
			Seat.seat();
			int ticket_seat_id = Help.getInt("请输入座位编号：");
			for(Ticket ticket : ticketList){
				if (ticket_seat_id == ticket.getTicket_seat_id()) {
					flag = false;
					
					while (!flag) {
						ticket_seat_id = Help.getInt("您选择的座位编号已被选择，请重新输入座位编号：");
						if(ticket_seat_id != ticket.getTicket_seat_id()){
							break;
						}
					}
				}
			}
			System.out.println();
			
			if(user.getUser_balance() < season.getSeason_price()){
				System.out.println("余额不足，无法购买，请充值！");
				return ;
			}
			
			Ticket ticket = new Ticket(season_id, ticket_seat_id, user_id);
			
			boolean success = ticketService.addTicket(ticket);
			
			if (success) {
				user.setUser_balance(user.getUser_balance() - season.getSeason_price());
				UserContro.setupCount(user_id, user.getUser_balance());
				
				System.out.println("购买成功，您的订单如下：");
				queryTicket(user.getUser_name());
				
				System.out.println("您的余额为：" + user.getUser_balance());
			} else {
				System.out.println("购买失败！\n");
			}
		} catch (Exception e) {
			System.out.println("您查找的影厅不存在！");
		}
	}
	
	//根据id删除影票信息
	public static void deleteTicket(){
		queryTicketName();
		
		int ticket_id = Help.getInt("请输入您要删除的影票编号：");
		
		boolean success = ticketService.deleteTicket(ticket_id);
		
		if(success){
			System.out.println("影院删除成功！\n");
			queryTicketName();
		}else{
			System.out.println("影院删除失败！\n");
		}
	}
	
	//查询影票信息和编号
	public static void queryTicketName(){
		List<Ticket> ticketList = ticketDao.querryTicket();
		
		if (ticketList.isEmpty()) {
			System.out.println("暂无影票！");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("影票编号：" + ticket.getTicket_id() + 
					"\n用户姓名：" + ticket.getUser().getUser_name() + 
					"\n电影名称：" + ticket.getMovie().getMovie_name() + 
					"\n"
				);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		ticketList.clear();
	} 
	
	//根据user_name查询影票信息
	public static void queryTicket(String user_name){
		List<Ticket> ticketList = ticketDao.queryTicket(user_name);
		
		if (ticketList.isEmpty()) {
			System.out.println("暂无影票！");
		}
		
		boolean success = ticketService.queryTicket();
		
		if (success) {
			for(Ticket ticket : ticketList){
				System.out.println("影票编号：" + ticket.getTicket_id() + 
					"\n影院名称：" + ticket.getCinema().getCinema_name() + 
					"\n影厅名称：" + ticket.getHall().getHall_name() + 
					"\n用户姓名：" + ticket.getUser().getUser_name() + 
					"\n电影名称：" + ticket.getMovie().getMovie_name() + 
					"\n电影时长：" + ticket.getMovie().getMovie_length() +
					"\n座位编号：" + ticket.getTicket_seat_id() +
					"\n电影价格：" + ticket.getSeason().getSeason_price() + 
					"\n放映时间：" + ticket.getSeason().getSeason_time() +
					"\n放映地址：" + ticket.getCinema().getCinema_address() +
					"\n"
				);
			}
		}else {
			System.out.println("查询失败！\n");
		}
		
		ticketList.clear();
	}
	
	//test
	public static void main(String[] args) {
		//查询所有影票
		queryTicket();
		
		//添加影票
		//addTicket(2);
		
		//删除影票
		//deleteTicket();
		
		//查询影票信息和编号
		//queryTicketName();
		
		//根据user_name查询影票信息
		//queryTicket("李四");
	}
}
