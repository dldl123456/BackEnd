package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.ITicketDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Movie;
import com.iotek.entity.Review;
import com.iotek.entity.Seat;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;
import com.iotek.entity.User;

public class TicketDao implements ITicketDao{
	private DbHelp db=null;
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public TicketDao(){
		db=new DbHelp();
	}
	@Override//Ticket t
	public boolean addTicket(User u, ShowPlan sp,int ro,int co) {
		if(u==null||sp==null){
			return false;
		}
		String sql="insert into tickets (id,userId,planId,buytime,prices) "
				+ "values (null,?,?,now(),?)";
		String sql2="select last_insert_id()";
		String sql3="insert into seats (id,co,ro,ticketId) values (null,?,?,?)";
		double prices=sp.getPrices()*u.getDiscount();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setInt(2, sp.getId());
			ps.setDouble(3,prices);
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql2);
				rs=ps.executeQuery();
				if(rs.next()){
					int ticketId=rs.getInt(1);
					ps=conn.prepareStatement(sql3);
					ps.setInt(1, co);
					ps.setInt(2, ro);
					ps.setInt(3, ticketId);
					int j=ps.executeUpdate();
					if(j!=0){
						System.out.println("座次表已经更新");
						return true;
					}
				}
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean deleteTicket(User u,Ticket t) {
		if(u.getId()!=t.getUserId()){
			return false;
		}
		String sql="update users set balance=balance+?,cost=cost-? "
				+ "where id=?";
		String sql2="delete from tickets where id=? and planId=? ";
		String sql3="delete from seats where ticketId =?";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql3);
			ps.setInt(1, t.getId());
			int k=ps.executeUpdate();
			if(k!=0){
				System.out.print(k+" ");
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, t.getId());
				ps.setInt(2, t.getPlanId());
				int i=ps.executeUpdate();
				if(i!=0){
					System.out.print(i+" ");
					ps=conn.prepareStatement(sql);
					ps.setDouble(1, t.getPrice());
					ps.setDouble(2, t.getPrice());
					ps.setInt(3, u.getId());
					int j=ps.executeUpdate();
					if(j!=0){
						System.out.println(j);
						return true;
					}else{
						System.out.println("退款失败");
					}
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		
		return false;
	}

	@Override
	public int deleteTickets(List<Ticket> tls) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteTickets(ShowPlan sp) {
		String sql="update users inner join"
				+ "(select tickets.userId,tickets.prices "+
				"from tickets inner join plans "
				+ "on tickets.planId=plans.id where plans.id=?) as t"
				+ " set balance=balance+t.prices,cost=cost-t.prices where id=t.userId";
		String sql2="delete from tickets where planId=?";
		String sql3="delete from seats where ticketId "
				+ " in (select id from tickets where planId=?)";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql3);
			ps.setInt(1, sp.getId());
			int k=ps.executeUpdate();
			if(k==0){
				return 0;
			}
			System.out.print(k+" ");
			ps=conn.prepareStatement(sql);
			ps.setInt(1,sp.getId());
			int i=ps.executeUpdate();
			if(i!=0){
				System.out.print(i+" ");
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, sp.getId());
				int j=ps.executeUpdate();
				if(j!=0){
					System.out.println(j);
					return j;
				}else{
					System.out.println("退款失败");
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		return 0;
	}

	@Override
	public boolean deleteTicket(Ticket t) {
		if(t==null){
			return false;
		}
		String sql="update users set balance=balance+?,cost=cost-? where id=?";
		String sql2="delete tickets where id=? and planId=?";
		String sql3="delete from seats where ticketId =?";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql3);
			ps.setInt(1, t.getId());
			int k=ps.executeUpdate();
			if(k!=0){
				System.out.println(k);
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, t.getId());
				ps.setInt(2, t.getPlanId());
				int i=ps.executeUpdate();
				if(i!=0){
					System.out.println(i);
					ps=conn.prepareStatement(sql);
					ps.setDouble(1, t.getPrice());
					ps.setDouble(2, t.getPrice());
					ps.setInt(3, t.getUserId());
					int j=ps.executeUpdate();
					if(j!=0){
						System.out.println(j);
						System.out.println("退票成功");
						return true;
					}else{
						System.out.println("退款失败");
					}
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, null);
		}
		
		return false;
	}

	@Override
	public List<Ticket> selectAllTickets() {
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",,s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ "inner join movies m on p.movieId=m.id order by t.id";
		List<Ticket> tls=new ArrayList<>();
		try {
			conn=db.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				Ticket t=new Ticket();
				t.setId(rs.getInt(1));
				t.setPlanId(rs.getInt(2));
				t.setBuytime(rs.getTimestamp(3));
				t.setPrice(rs.getDouble(4));
				t.setShowtime(rs.getTimestamp(5));
				t.setUserId(rs.getInt(6));
				Seat s=new Seat();
				s.setId(rs.getInt(7));
				s.setRow(rs.getInt(8));
				s.setColum(rs.getInt(9));
				t.setMovieName(rs.getString(10));
				t.setSeat(s);
				tls.add(t);
			}
			return tls;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return tls;
	}

	@Override
	public List<Ticket> selectTickets(ShowPlan sp) {
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",,s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ "inner join movies m on p.movieId=m.id "
				+ " where p.id=? order by t.id";
		List<Ticket> tls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sp.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				Ticket t=new Ticket();
				t.setId(rs.getInt(1));
				t.setPlanId(rs.getInt(2));
				t.setBuytime(rs.getTimestamp(3));
				t.setPrice(rs.getDouble(4));
				t.setShowtime(rs.getTimestamp(5));
				t.setUserId(rs.getInt(6));
				Seat s=new Seat();
				s.setId(rs.getInt(7));
				s.setRow(rs.getInt(8));
				s.setColum(rs.getInt(9));
				t.setMovieName(rs.getString(10));
				t.setSeat(s);
				tls.add(t);
			}
			return tls;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return tls;
	}

	@Override
	public Ticket selectTicket(int ticketId) {
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",,s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ "inner join movies m on p.movieId=m.id "
				+ " where t.id=? order by t.id";
		Ticket t=null;
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			rs=ps.executeQuery();
			while(rs.next()){
				t=new Ticket();
				t.setId(rs.getInt(1));
				t.setPlanId(rs.getInt(2));
				t.setBuytime(rs.getTimestamp(3));
				t.setPrice(rs.getDouble(4));
				t.setShowtime(rs.getTimestamp(5));
				t.setUserId(rs.getInt(6));
				Seat s=new Seat();
				s.setId(rs.getInt(7));
				s.setRow(rs.getInt(8));
				s.setColum(rs.getInt(9));
				t.setMovieName(rs.getString(10));
				t.setSeat(s);
			}
			return t;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return t;
	}

	@Override
	public List<Ticket> selectTickets(User u) {
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ " inner join movies m on p.movieId=m.id "
				+ " where t.userId=? order by t.buytime desc";
		List<Ticket> tls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				Ticket t=new Ticket();
				t.setId(rs.getInt(1));
				t.setPlanId(rs.getInt(2));
				t.setBuytime(rs.getTimestamp(3));
				t.setPrice(rs.getDouble(4));
				t.setShowtime(rs.getTimestamp(5));
				t.setUserId(rs.getInt(6));
				Seat s=new Seat();
				s.setId(rs.getInt(7));
				s.setRow(rs.getInt(8));
				s.setColum(rs.getInt(9));
				t.setMovieName(rs.getString(10));
				t.setSeat(s);
				tls.add(t);
			}
			return tls;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return tls;
	}

	@Override
	public List<Review> selectUnwriteTickets(User u) {
		List<Review> rls=new ArrayList<>();
		String sql="select t.id,m.id,m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime"
				+ " from tickets t "
				+ " inner join plans p on t.planId=p.id "
				+ " inner join movies m on p.movieId=m.id "
				+ " left join reviews r on t.id=r.ticketId "
				+ " where t.userId=? and r.ticketId is null and p.showtime<now()"
				+ " order by t.buytime desc";
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				Review r=new Review();
				r.setTickId(rs.getInt(1));
				Movie m=new Movie();
				m.setId(rs.getInt(2));
				m.setName(rs.getString(3));
				m.setDirector(rs.getString(4));
				m.setStars(rs.getString(5));
				m.setType(rs.getString(6));
				m.setMins(rs.getInt(7));
				m.setIntro(rs.getString(8));
				m.setMark(rs.getDouble(9));
				m.setStatus(rs.getString(10));
				m.setOpenTime(rs.getDate(11));
				r.setMovie(m);
				rls.add(r);
			}
			return rls;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
	@Override
	public List<Ticket> selectTickets(Movie m) {
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",,s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ "inner join movies m on p.movieId=m.id "
				+ " where m.id=? order by t.id";
		List<Ticket> tls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				Ticket t=new Ticket();
				t.setId(rs.getInt(1));
				t.setPlanId(rs.getInt(2));
				t.setBuytime(rs.getTimestamp(3));
				t.setPrice(rs.getDouble(4));
				t.setShowtime(rs.getTimestamp(5));
				t.setUserId(rs.getInt(6));
				Seat s=new Seat();
				s.setId(rs.getInt(7));
				s.setRow(rs.getInt(8));
				s.setColum(rs.getInt(9));
				t.setMovieName(rs.getString(10));
				t.setSeat(s);
				tls.add(t);
			}
			return tls;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return tls;
	}

	@Override
	public boolean addTicket(Ticket t) {
		String sql="insert into tickets (id,userId,planId,buytime,prices) "
				+ "values (?,?,?,now(),?)";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
			ps.setInt(2, t.getUserId());
			ps.setInt(3, t.getPlanId());
			ps.setDouble(4,t.getPrice());
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		
		return false;
	}
	@Override
	public int getMaxTicketId() {
		String sql="select max(id) from tickets";
		conn=db.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return 0;
	}
	@Override
	public List<Seat> selectSeats(ShowPlan sp) {
		List<Seat> sls=new ArrayList<>();
		String sql="select s.id,s.ro,s.co,s.hallId,s.ticketId from"
				+ " seats s inner join tickets t on t.id=s.ticketId "
				+ " inner join  plans p on p.id =t.planId "
				+ " where p.id=?";
		conn=db.getConnection();
		 try {
			ps=conn.prepareStatement(sql);
			 ps.setInt(1, sp.getId());
			 rs=ps.executeQuery();
			 while(rs.next()){
				 Seat s=new Seat();
				 s.setId(rs.getInt(1));
				 s.setRow(rs.getInt(2));
				 s.setColum(rs.getInt(3));
				 s.setHallId(rs.getInt(4));
				 s.setTicketId(rs.getInt(5));
				 sls.add(s);
			 }
			 if(sls.isEmpty()){
				 return null;
			 }
			 return sls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
	
		 
		return null;
	}
}
