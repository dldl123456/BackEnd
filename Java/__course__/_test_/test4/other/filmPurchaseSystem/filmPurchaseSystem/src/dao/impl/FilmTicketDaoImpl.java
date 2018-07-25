package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FilmTicketDao;
import dbutil.DbADUClose;
import entity.FilmTicket;

public class FilmTicketDaoImpl extends DbADUClose implements FilmTicketDao {

	@Override
	public int addFilmTicket(FilmTicket filmTicket) throws Exception {
		String sql="insert into filmTicket values (default,?,?,?,?,?)";
		Object[] params = {filmTicket.getTicketUser(),filmTicket.getTicketMovie(),
				filmTicket.getTicketSession(),filmTicket.getTicketSeat(),filmTicket.getTicketStatus()};
		return super.executeUpdate(sql, params);
	}
	
	@Override
	public int updateFilmTicketStatus(int ticketId) throws Exception {
		String sql = "update filmticket set ticket_status=1 where ticket_id=?";
		Object[] params = {ticketId};
		return super.executeUpdate(sql, params);
	}
	
	@Override
	public List<FilmTicket> queryFilmTicketsByUser(int userId) throws Exception {
		try {
			List<FilmTicket> filmTickets = new ArrayList<FilmTicket>();
			String sql="select ticket_id,ticket_user,ticket_movie,ticket_session,ticket_seat,"
					+ "ticket_status from filmticket,user where ticket_user=user_id and user_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				filmTickets.add(filmTicket);
			}
			return filmTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<FilmTicket> queryFilmTicketsByCinema(int cinemaId) throws Exception {
		try {
			List<FilmTicket> filmTickets = new ArrayList<FilmTicket>();
			String sql="select ticket_id,ticket_user,ticket_movie,ticket_session,ticket_seat,"
					+ "ticket_status from filmticket,seat,hall,cinema where ticket_seat=seat_id and seat_hall=hall_id "
					+ "and hall_cinema=cinema_id and cinema_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cinemaId);
			rs=ps.executeQuery();
			while(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				filmTickets.add(filmTicket);
			}
			return filmTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public List<FilmTicket> queryFilmTicketsByMovie(int movieId) throws Exception {
		try {
			List<FilmTicket> filmTickets = new ArrayList<FilmTicket>();
			String sql="select ticket_id,ticket_user,ticket_movie,ticket_session,ticket_seat,"
					+ "ticket_status from filmticket,movie where ticket_movie=movie_id and movie_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, movieId);
			rs=ps.executeQuery();
			while(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				filmTickets.add(filmTicket);
			}
			return filmTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public List<FilmTicket> queryFilmTicketsByMovieCinema(int movieId,int cinemaId) throws Exception {
		try {
			List<FilmTicket> filmTickets = new ArrayList<FilmTicket>();
			String sql="select ticket_id,ticket_user,ticket_movie,ticket_session,ticket_seat,"
					+ "ticket_status from filmticket,movie,cinema where ticket_movie=movie_id and ticket_movie=movie_id"
					+ " and movie_id=? and cinema_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, movieId);
			ps.setInt(2, cinemaId);
			rs=ps.executeQuery();
			while(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				filmTickets.add(filmTicket);
			}
			return filmTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public List<FilmTicket> queryFilmTickets() throws Exception {
		try {
			List<FilmTicket> filmTickets = new ArrayList<FilmTicket>();
			String sql ="select * from filmticket";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				filmTickets.add(filmTicket);
			}
			return filmTickets;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public FilmTicket queryFilmTicket(int ticketId) throws Exception {
		try {
			String sql ="select * from filmTicket where ticket_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, ticketId);
			rs=ps.executeQuery();
			if(rs.next()) {
				FilmTicket filmTicket=new FilmTicket();
				filmTicket.setTicketId(rs.getInt(1));
				filmTicket.setTicketUser(rs.getInt(2));
				filmTicket.setTicketMovie(rs.getInt(3));
				filmTicket.setTicketSession(rs.getInt(4));
				filmTicket.setTicketSeat(rs.getInt(5));
				filmTicket.setTicketStatus(rs.getInt(6));
				return filmTicket;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public int comparisonTicketId(int inputTicketId,int userId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryFilmTicketsByUser(userId).size();i++) {
			if(inputTicketId==queryFilmTicketsByUser(userId).get(i).getTicketId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
