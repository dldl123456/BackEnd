package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeatDao;
import dbutil.DbADUClose;
import entity.Seat;

public class SeatDaoImpl extends DbADUClose implements SeatDao {

	@Override
	public int addSeat(Seat seat) throws Exception {
		String sql="insert into Seat values (default,?,?,?,default)";
		Object[] params = {seat.getSeatRow(),seat.getSeatRank(),seat.getSeatHall()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteSeatById(int seatId) throws Exception {
		String sql="delete from seat where seat_id=?";
		Object[] params = {seatId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteSeatByRow(int row, int hallId) throws Exception {
		String sql="delete seat from seat,hall where seat_hall=hall_id and seat_row=? and hall_id=?";
		Object[] params = {row,hallId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteSeatByRank(int rank, int hallId) throws Exception {
		String sql="delete seat from seat,hall where seat_hall=hall_id and seat_rank=? and hall_id=?";
		Object[] params = {rank,hallId};
		return super.executeUpdate(sql, params);
	}
	
	@Override
	public void deleteSeatCinemaIsNull() throws Exception {
		String sql="delete seat from hall right join seat on seat.seat_hall=hall.hall_id where hall.hall_id is null";
		ps=super.getConnection().prepareStatement(sql);
		int i=ps.executeUpdate();
		if(i>0) {
			System.out.println("相关座位删除成功！");
		}else {
			System.out.println("相关座位未删除！！！");
		}		
	}

	@Override
	public void deleteSeatHallIsNull() throws Exception {
		String sql="delete seat from seat left join hall on seat.seat_hall=hall.hall_id where hall_id is null";
		ps=super.getConnection().prepareStatement(sql);
		int i=ps.executeUpdate();
		if(i>0) {
			System.out.println("相关座位删除成功！");
		}else {
			System.out.println("相关座位未删除！！！");
		}		
	}
	/**
	 * 修改座位状态的方法
	 */
	@Override
	public int updateSeatStatusById(int seatId,int status) throws Exception{
		String sql="update seat set seat_status=? where seat_id=?";
		Object[] params= {status,seatId};
		return super.executeUpdate(sql, params);	
	}
	@Override
	public int updateSeatStatusByHall(int hallId, int status) throws Exception {
		String sql="update seat set seat_status=? where seat_hall=?";
		Object[] params= {status,hallId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Seat> querySeats() throws Exception {
		try {
			List<Seat> seats = new ArrayList<Seat>();
			String sql ="select seat_id, seat_row,seat_rank,seat_hall,seat_status from seat,city,cinema,hall "
					+ "where city_id=seat_city and cinema_id=seat_cinema and hall_id=seat_hall";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Seat seat=new Seat();
				seat.setSeatId(rs.getInt(1));
				seat.setSeatRow(rs.getInt(2));
				seat.setSeatRank(rs.getInt(3));
				seat.setSeatHall(rs.getInt(4));
				seat.setSeatStatus(rs.getInt(5));
				seats.add(seat);
			}
			return seats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	

	@Override
	public List<Seat> querySeatsByHall(int hallId) throws Exception {
		try {
			List<Seat> seats = new ArrayList<Seat>();
			String sql ="select seat_id, seat_row,seat_rank,seat_hall,seat_status from seat,city,cinema,hall "
					+ "where city_id=cinema_city and cinema_id=hall_cinema and hall_id=seat_hall and hall_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, hallId);
			rs=ps.executeQuery();
			while(rs.next()) {
				Seat seat=new Seat();
				seat.setSeatId(rs.getInt(1));
				seat.setSeatRow(rs.getInt(2));
				seat.setSeatRank(rs.getInt(3));
				seat.setSeatHall(rs.getInt(4));
				seat.setSeatStatus(rs.getInt(5));
				seats.add(seat);
			}
			return seats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public Seat querySeatById(int SeatId) throws Exception {
		try {
			String sql ="select seat_id, seat_row,seat_rank,seat_hall,seat_status from seat,city,cinema,hall "
					+ "where city_id=cinema_city and cinema_id=hall_cinema and hall_id=seat_hall and seat_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, SeatId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Seat seat=new Seat();
				seat.setSeatId(rs.getInt(1));
				seat.setSeatRow(rs.getInt(2));
				seat.setSeatRank(rs.getInt(3));
				seat.setSeatHall(rs.getInt(4));
				seat.setSeatStatus(rs.getInt(5));
				return seat;
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
	public int comparisonSeatId(int inputSeatId,int hallId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySeatsByHall(hallId).size();i++) {
			if(inputSeatId==querySeatsByHall(hallId).get(i).getSeatId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}

	@Override
	public int comparisonSeatId(int inputSeatId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<querySeats().size();i++) {
			if(inputSeatId==querySeats().get(i).getSeatId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
