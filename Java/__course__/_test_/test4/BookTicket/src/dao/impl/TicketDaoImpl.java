package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDao;
import dbhelp.DbHelp;
import entity.Cinema;
import entity.Hall;
import entity.Movie;
import entity.Season;
import entity.Ticket;
import entity.User;

/**
 * 
 * @param 实现影票类数据接口
 * @author zmx2321
 * 
 */

public class TicketDaoImpl implements TicketDao {
	private DbHelp db;
	private Connection conn;
	private List<Ticket> list;
	
	//构造方法初始化
	public TicketDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//查看影票信息
	@Override
	public List<Ticket> querryTicket() {
		conn = db.getConnection();
		String sql = "SELECT t.ticket_id, c.cinema_name, h.hall_name, "
				+ "u.user_name, m.movie_name, m.movie_length, "
				+ "t.ticket_seat_id, s.season_price, s.season_time, c.cinema_address "
				+ "FROM ticket t, season s, user u, movie m, cinema c, hall h "
				+ "WHERE t.season_id = s.season_id AND t.user_id = u.user_id "
				+ "AND s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id;";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			//一条一条地记录信息
			while(rs.next()){
				Ticket ticket = new Ticket();
				
				ticket.setCinema(new Cinema());
				ticket.setHall(new Hall());
				ticket.setSeason(new Season());
				ticket.setMovie(new Movie());
				ticket.setUser(new User());
				
				ticket.setTicket_id(rs.getInt("ticket_id"));
				ticket.getCinema().setCinema_name(rs.getString("cinema_name"));
				ticket.getHall().setHall_name(rs.getString("hall_name"));
				ticket.getUser().setUser_name(rs.getString("user_name"));
				ticket.getMovie().setMovie_name(rs.getString("movie_name"));
				ticket.getMovie().setMovie_length(rs.getString("movie_length"));
				ticket.setTicket_seat_id(rs.getInt("ticket_seat_id"));
				ticket.getSeason().setSeason_price(rs.getFloat("season_price"));
				ticket.getSeason().setSeason_time(rs.getString("season_time"));
				ticket.getCinema().setCinema_address(rs.getString("cinema_address"));
				
				list.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	//添加影票信息
	@Override
	public int addTicket(Ticket ticket) {
		conn = db.getConnection();
		String sql = "INSERT INTO `ticket` "
				+ "(`season_id`, `ticket_seat_id`, `user_id`) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement ps  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ticket.getSeason_id());
			ps.setInt(2, ticket.getTicket_seat_id());
			ps.setInt(3, ticket.getUser_id());
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//删除影票信息
	@Override
	public int deleteTicket(int ticket_id) {
		conn = db.getConnection();
		String sql = "delete from ticket where ticket_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ticket_id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//根据user_name查询影票信息
	@Override
	public List<Ticket> queryTicket(String user_name){
		Ticket ticket = null;
		
		conn = db.getConnection();
		String sql = "SELECT t.ticket_id, c.cinema_name, h.hall_name, "
				+ "u.user_name, m.movie_name, m.movie_length, "
				+ "t.ticket_seat_id, s.season_price, s.season_time, c.cinema_address "
				+ "FROM ticket t, season s, user u, movie m, cinema c, hall h "
				+ "WHERE t.season_id = s.season_id AND t.user_id = u.user_id "
				+ "AND s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id AND user_name= ?";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user_name);
			
			rs = ps.executeQuery();

			//一条一条地记录信息
			while(rs.next()){
				ticket = new Ticket();
				
				ticket.setCinema(new Cinema());
				ticket.setHall(new Hall());
				ticket.setSeason(new Season());
				ticket.setMovie(new Movie());
				ticket.setUser(new User());
				
				ticket.setTicket_id(rs.getInt("ticket_id"));
				ticket.getCinema().setCinema_name(rs.getString("cinema_name"));
				ticket.getHall().setHall_name(rs.getString("hall_name"));
				ticket.getUser().setUser_name(rs.getString("user_name"));
				ticket.getMovie().setMovie_name(rs.getString("movie_name"));
				ticket.getMovie().setMovie_length(rs.getString("movie_length"));
				ticket.setTicket_seat_id(rs.getInt("ticket_seat_id"));
				ticket.getSeason().setSeason_price(rs.getFloat("season_price"));
				ticket.getSeason().setSeason_time(rs.getString("season_time"));
				ticket.getCinema().setCinema_address(rs.getString("cinema_address"));
				
				list.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}
	
	
	//test
	public static void main(String[] args) {
		TicketDaoImpl ticketDao = new TicketDaoImpl();
		
		//添加影票信息
		/*Ticket ticket = new Ticket(1, 16, 1);
		System.out.println(ticketDao.addTicket(ticket));
		System.out.println();*/
		
		//查看影票信息
		/*System.out.println("***** 查询 *****");
		List<Ticket> tickeList = ticketDao.querryTicket();
		for(Ticket ticket : tickeList){
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
		System.out.println();*/
		
		//删除影票信息
		//System.out.println(ticketDao.deleteTicket(1));
		
		//根据user_name查询影票信息
		//System.out.println("***** 查询 *****");
		List<Ticket> tickeList = ticketDao.queryTicket("李四");
		for(Ticket ticket : tickeList){
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
		System.out.println();
	}
}
