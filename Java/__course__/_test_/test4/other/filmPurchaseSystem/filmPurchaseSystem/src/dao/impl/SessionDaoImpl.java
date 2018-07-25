package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.SessionDao;
import dbutil.DbADUClose;
import entity.Session;
import help.Time;

public class SessionDaoImpl extends DbADUClose implements SessionDao {

	@Override
	public int addSession(Session session) throws Exception {
		String sql="insert into session values (default,?,?,?,?)";
		Object[] params = {session.getSessionHall(),session.getSessionStarttime(),
				session.getSeesionStoptime(),session.getSessionMovie()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int updateSession(Session session) throws Exception {
		String sql="update session set session_hall=?,session_starttime=?,"
				+ "session_stoptime=?,session_movie=? where session_id=?";
		Object[] params= {session.getSessionHall(),session.getSessionStarttime(),
				session.getSeesionStoptime(),session.getSessionMovie(),session.getSessionId()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Session> querySessionByMovieName(String movieName) throws Exception {
		try {
			List<Session> sessions = new ArrayList<Session>();
			String sql="select session_id,session_hall,session_starttime,seesion_stoptime,session_movie"
					+ " from session,movie where session_movie=movie_id and movie_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, movieName);
			rs=ps.executeQuery();
			while(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));	
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				sessions.add(session);
			}
			return sessions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public List<Session> querySessionByCinema(String cinemaName,String cityName) throws Exception {
		try {
			List<Session> sessions = new ArrayList<Session>();
			String sql="select session_id,session_hall,session_starttime,seesion_stoptime,session_movie from"
					+ " session,movie,hall,cinema,city where session_hall=hall_id and hall_cinema=cinema_id "
					+ "and cinema_city=city_id AND session_movie=movie_id and cinema_name=? and city_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cinemaName);
			ps.setString(2, cityName);
			rs=ps.executeQuery();
			while(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				sessions.add(session);
			}
			return sessions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public List<Session> querySessionByHall(int HallId) throws Exception {
		try {
			List<Session> sessions = new ArrayList<Session>();
			String sql="select session_id,session_hall,session_starttime,seesion_stoptime,session_movie "
					+ "from session,hall where session_hall=hall_id and hall_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, HallId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				sessions.add(session);
			}
			return sessions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	
	@Override
	public List<Session> querySessions() throws Exception {
		try {
			List<Session> sessions = new ArrayList<Session>();
			String sql ="select * from session";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				sessions.add(session);
			}
			return sessions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public int deleteSession(int sessionId) throws Exception {
		String sql = "delete from session where session_id=?";
		Object[] params = {sessionId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Session> querySessionByCinemaMovie(String cinemaName, String movieName,String cityName) throws Exception {
		try {
			List<Session> sessions = new ArrayList<Session>();
			String sql="select session_id,session_hall,session_starttime,seesion_stoptime,session_movie"
					+ " from session,movie,hall,cinema,city where "
					+ "session_hall=hall_id and hall_cinema=cinema_id and cinema_city=city_id and "
					+ " session_movie=movie_id and city_name=? and cinema_name=? and movie_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cityName);
			ps.setString(2, cinemaName);
			ps.setString(3, movieName);
			rs=ps.executeQuery();
			while(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				sessions.add(session);
			}
			return sessions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public Session querySessionById(int sessionId) throws Exception {
		try {
			String sql="select session_id,session_hall,session_starttime,seesion_stoptime,session_movie"
					+ " from session,movie,hall,cinema where "
					+ "session_hall=hall_id and hall_cinema=cinema_id and "
					+ " session_movie=movie_id and session_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, sessionId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Session session=new Session();
				session.setSessionId(rs.getInt(1));
				session.setSessionHall(rs.getInt(2));
				session.setSessionStarttime(rs.getString(3));
				session.setSeesionStoptime(rs.getString(4));
				session.setSessionMovie(rs.getInt(5));
				return session;
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
	public int comparisonSessionId(int inputSessionId,String cinemaName,String movieName,String cityName) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySessionByCinemaMovie(cinemaName, movieName, cityName).size();i++) {
			if(inputSessionId==querySessionByCinemaMovie(cinemaName, movieName, cityName).get(i).getSessionId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}

	@Override
	public int comparisonSessionHall(int hallId, Date time) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySessionByHall(hallId).size();i++) {
			String startTime =querySessionByHall(hallId).get(i).getSessionStarttime();
			Date starttime=Time.StringToDate(startTime);
			String stopTime =querySessionByHall(hallId).get(i).getSeesionStoptime();
			Date stoptime =Time.StringToDate(stopTime);
			boolean flag = Time.compareTo1(starttime, stoptime, time);
			if(flag==false) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	@Override
	public int comparisonSession(String movieName,Date time) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySessionByMovieName(movieName).size();i++) {
			String stopTime =querySessionByMovieName(movieName).get(i).getSeesionStoptime();
			Date stoptime =Time.StringToDate(stopTime);
			boolean flag = Time.compareTo2(stoptime,time);
			if(flag==false) {
				Num=i;
				break;
			}
		}
		return Num;
	}

	@Override
	public int comparisonSessionByid(int inputSessionId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySessions().size();i++) {
			if(inputSessionId==querySessions().get(i).getSessionId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
