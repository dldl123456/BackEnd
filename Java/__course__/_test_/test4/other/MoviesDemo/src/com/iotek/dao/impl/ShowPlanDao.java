package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.IShowPlanDao;
import com.iotek.dbHelp.DbHelp;
import com.iotek.entity.Movie;
import com.iotek.entity.Seat;
import com.iotek.entity.ShowHall;
import com.iotek.entity.ShowPlan;
import com.iotek.entity.Theater;
import com.iotek.entity.Ticket;

public class ShowPlanDao implements IShowPlanDao {
	private DbHelp db=null;
	private Connection conn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public ShowPlanDao(){
		db=new DbHelp();
	}
	
	@Override
	public List<ShowPlan> selectAllShowPlans(Movie m) {
		if(m==null){
			return null;
		}
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " where m.id=? ";
		List<ShowPlan> spls=new ArrayList<>();
		
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				sp.setMovie(m);
				spls.add(sp);
			}
			return spls;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public ShowPlan getShowPlan(int planId) {
		String sql="select p.hallId,p.movieId,p.showtime,p.prices"
				+ ",m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime"
				+ " from "
				+ " plans p inner join movies m on p.movieId=m.id "
				+ " where p.id=?";
		ShowPlan sp=null;
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, planId);
			rs=ps.executeQuery();
			if(rs.next()){
				sp=new ShowPlan();
				sp.setId(planId);
				sp.setHallId(rs.getInt(1));
				sp.setMovieId(rs.getInt(2));
				sp.setShowtime(rs.getTimestamp(3));
				sp.setPrices(rs.getDouble(4));
				Movie m=new Movie();
				m.setId(rs.getInt(2));
				m.setName(rs.getString(5));
				m.setDirector(rs.getString(6));
				m.setStars(rs.getString(7));
				m.setType(rs.getString(8));
				m.setMins(rs.getInt(9));
				m.setIntro(rs.getString(10));
				m.setMark(rs.getDouble(11));
				m.setStatus(rs.getString(12));
				m.setOpenTime(rs.getDate(13));
				sp.setMovie(m);
			}
			return sp;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<ShowPlan> selectShowPlans(ShowHall hall) {
		if(hall==null){
			return null; 
		}
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices'"
				+ ",m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime"
				+ " from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " inner join halls h on h.id=p.hallId "
				+ " where p.hallId=? and p.showtime>now() order by showtime";
		List<ShowPlan> spls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, hall.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				Movie m=new Movie();
				m.setId(rs.getInt(3));
				m.setName(rs.getString(6));
				m.setDirector(rs.getString(7));
				m.setStars(rs.getString(8));
				m.setType(rs.getString(9));
				m.setMins(rs.getInt(10));
				m.setIntro(rs.getString(11));
				m.setMark(rs.getDouble(12));
				m.setStatus(rs.getString(13));
				m.setOpenTime(rs.getDate(14));
				sp.setMovie(m);
				sp.setHall(hall);
				spls.add(sp);
			}
			return spls;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}
//	public static void main(String []args){
//		Timestamp time=new Timestamp(System.currentTimeMillis());
//		System.out.println(time);
//		ShowPlanDao sp=new ShowPlanDao();
//		List<ShowPlan> tls=sp.selectShowPlans(time);
//		for(ShowPlan stp:tls){
//			System.out.println(stp.getId());
//		}
//	}

	@Override
	public List<ShowPlan> selectShowPlans(Timestamp time) {
		if(time==null){
			return null; 
		}
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices"
				+ ",m.name,m.director,m.stars"
				+ ",m.type,m.mins,m.intro,m.mark,m.status,m.opentime "
				+ " from  plans p inner join movies m on p.movieId=m.id "
				+ " where p.showtime > ? ";
		System.out.println(sql);
		List<ShowPlan> spls=new ArrayList<>();
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setTimestamp(1, time);
			rs=ps.executeQuery();
			if(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				Movie m=new Movie();
				m.setId(rs.getInt(3));
				m.setName(rs.getString(6));
				m.setDirector(rs.getString(7));
				m.setStars(rs.getString(8));
				m.setType(rs.getString(9));
				m.setMins(rs.getInt(10));
				m.setIntro(rs.getString(11));
				m.setMark(rs.getDouble(12));
				m.setStatus(rs.getString(13));
				m.setOpenTime(rs.getDate(14));
				sp.setMovie(m);
				spls.add(sp);
			}
			return spls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public int addShowPlan(ShowPlan plan) {
		String sql="insert into plans (id,movieId,hallId,showtime,prices) values (null,?,?,?,?)";
		conn=db.getConnection();
		String sql2="update movies set status='1' where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, plan.getMovieId());
			ps.setInt(2, plan.getHallId());
			ps.setTimestamp(3, plan.getShowtime());
			ps.setDouble(4, plan.getPrices());
			int i=ps.executeUpdate();
			if(i!=0){
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, plan.getMovie().getId());
				int j=ps.executeUpdate();
				if(j!=0){
					System.out.println("更新电影状态");
				}
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn,ps, rs);
		}
		return 0;
	}

	@Override
	public int addShowPlans(List<ShowPlan> pls) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ShowPlan> selectShowPlans(Movie m) {
		if(m==null){
			return null;
		}
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " where m.id=? and showtime>now() order by showtime desc";
		List<ShowPlan> spls=new ArrayList<>();
		
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				sp.setMovie(m);
				spls.add(sp);
			}
			return spls;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Ticket> canDelete(ShowPlan sp) {
		if(sp==null){
			return null;
		}
		conn=db.getConnection();
		String sql="select t.id,t.planId,t.buytime,t.prices,"
				+ "p.showtime,t.userId"
				+ ",s.id,s.ro,s.co,m.name"
				+ " from tickets t inner join seats s on t.id=s.ticketId"
				+ " inner join plans p on t.planId=p.id "
				+ " inner join movies m on p.movieId=m.id "
				+ " where p.id=? and p.showtime>now()";
		List<Ticket> tls=new ArrayList<>();
		try {
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
			if(tls.isEmpty()){
				return null;
			}
			return tls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		return null;
	}

	@Override
	public boolean deleteShowPlan(ShowPlan sp) {
		if(sp==null){
			return true;
		}
		String sql="delete from plans where id=?";
		conn=db.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,sp.getId());
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
//吧电影的开始时间和结束时间一起传进来然后判断这个时间段该影厅的前一部电影和后一部电影是否会在这个时间段内
	//是否需要写一个展示这一天这个影厅的场次情况，方便管理员来控制时间？
	@Override
	public boolean timeIsOk(Timestamp time, Timestamp atime, ShowHall hall) {
		if(time==null ||atime==null){
			return false;
		}
		String sql2="select p.showtime,m.mins,p.id,p.hallId,p.movieId,p.prices from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " inner join showhalls h on h.id=p.hallId "
				+ " where h.id=?  and p.showtime<=? order by showtime desc limit 1";
		String sql="select p.showtime,m.mins,p.id,p.hallId,p.movieId,p.prices from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " inner join showhalls h on h.id=p.hallId "
				+ " where h.id=? and p.showtime between ? and ? order by p.showtime desc limit 1 ";
		conn=db.getConnection();
		Timestamp time1=null;
		int mins=0;
		Timestamp time2=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, hall.getId());
			ps.setTimestamp(2, time);
			ps.setTimestamp(3, atime);
			rs=ps.executeQuery();
			if(rs.next()){
				time1=rs.getTimestamp(1);
				mins=rs.getInt(2);
				//System.out.println("在"+time1+"这个时间该影厅有一场电影,请电影时长为："+mins+"，请重新选择时间");
				return false;
			}
			ps=conn.prepareStatement(sql2);
			ps.setInt(1, hall.getId());
			ps.setTimestamp(2, time);
			rs=ps.executeQuery();
			if(rs.next()){
				mins=rs.getInt(2);
				 time1=rs.getTimestamp(1);
				 time2=new Timestamp(time1.getTime()+mins*60000);
				//System.out.println("在"+time1+"这个时间该影厅有一场电影,结束时间为"+time2);
				
				if(time2.after(time)){
					//System.out.println(time1);
					return false;
				}
				System.out.println("haha3");
				return true;
			}
			System.out.println();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeAll(conn, ps, rs);
		}
		
		return false;
	}

	@Override
	public List<ShowPlan> selectShowPlans() {
		
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices"
				+ ",m.name,m.director,m.stars,m.type,m.mins,m.intro,"
				+ "m.mark,m.status,m.opentime from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " where m.status<>'-1' ";
		List<ShowPlan> spls=new ArrayList<>();
		
		try {
			conn=db.getConnection();
		st=conn.createStatement();
			
			rs=st.executeQuery(sql);
			while(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				Movie m=new Movie();
				m.setId(rs.getInt(3));
				m.setName(rs.getString(6));
				m.setDirector(rs.getString(7));
				m.setStars(rs.getString(8));
				m.setType(rs.getString(9));
				m.setMins(rs.getInt(10));
				m.setIntro(rs.getString(11));
				m.setMark(rs.getDouble(12));
				m.setStatus(rs.getString(13));
				m.setOpenTime(rs.getDate(14));
				sp.setMovie(m);
				spls.add(sp);
			}
			if(spls.isEmpty()){
				return null;
			}
			return spls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}

	@Override
	public List<ShowPlan> selectShowPlans(Theater t) {
		String sql="select p.id,p.hallId,p.movieId,p.showtime,p.prices"
				+ ",m.name,m.director,m.stars,m.type,m.mins,m.intro,"
				+ "m.mark,m.status,m.opentime,h.title,h.cos,h.ros from "
				+ " plans p inner join movies m on p.movieId=m.id"
				+ " inner join showhalls h on h.id=p.hallId "
				+ " inner join theaters t on t.id=h.id "
				+ " where m.status<>'-1' and p.showtime>now() and t.id=? ";
		List<ShowPlan> spls=new ArrayList<>();
		
		try {
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, t.getId());
			rs=ps.executeQuery();
			while(rs.next()){
				ShowPlan sp=new ShowPlan();
				sp.setId(rs.getInt(1));
				sp.setHallId(rs.getInt(2));
				sp.setMovieId(rs.getInt(3));
				sp.setShowtime(rs.getTimestamp(4));
				sp.setPrices(rs.getDouble(5));
				Movie m=new Movie();
				m.setId(rs.getInt(3));
				m.setName(rs.getString(6));
				m.setDirector(rs.getString(7));
				m.setStars(rs.getString(8));
				m.setType(rs.getString(9));
				m.setMins(rs.getInt(10));
				m.setIntro(rs.getString(11));
				m.setMark(rs.getDouble(12));
				m.setStatus(rs.getString(13));
				m.setOpenTime(rs.getDate(14));
				sp.setMovie(m);
				ShowHall hall=new ShowHall();
				hall.setTheater(t);
				hall.setTitle(rs.getString(15));
				hall.setColums(rs.getInt(16));
				hall.setRows(rs.getInt(16));
				hall.setTheaterId(t.getId());
				sp.setHall(hall);
				spls.add(sp);
			}
			if(spls.isEmpty()){
				return null;
			}
			return spls;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			db.closeAll(conn, st, rs);
		}
		return null;
	}

}
