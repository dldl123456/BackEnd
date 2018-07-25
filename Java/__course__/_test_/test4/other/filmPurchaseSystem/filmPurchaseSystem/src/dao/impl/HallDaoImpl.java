package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.HallDao;
import dbutil.DbADUClose;
import entity.Hall;

public class HallDaoImpl extends DbADUClose implements HallDao {
	/**
	 * 添加影厅信息（增）
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addHall(Hall hall) throws Exception {
		String sql="insert into Hall values (default,?,?,)";
		Object[] params = {hall.getHallName(),hall.getHallCinema()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 删除影厅信息（删）
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteHall(String cityName,String cinemaName,String hallName) throws Exception {
		String sql="delete hall from cinema,hall,city where cineam_city=city_id and"
				+ " hall_cinema=cinema_id and city_name=? and cinema_name=? and hall_name=?";
		Object[] params = {cityName,cinemaName,hallName};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 修改影厅名称
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateHallName(String hallName,int hallId) throws Exception {
		String sql="update hall set hall_name=? where hall_id=?";
		Object[] params= {hallName,hallId};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 根据影厅和影院查询影厅信息
	 * @param hallId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Hall queryHall(String cityName,String cinemaName,String hallName) throws Exception {
		try {
			String sql="select hall_id, hall_name,hall_cinema from hall,cinema,city where "
					+ "city_id=cinema_city and cinema_id=hall_cinema and city_name=? and cinema_name=? and hall_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cityName);
			ps.setString(2, cinemaName);
			ps.setString(3, hallName);
			rs=ps.executeQuery();
			if(rs.next()) {
				Hall hall=new Hall();
				hall.setHallId(rs.getInt(1));
				hall.setHallName(rs.getString(2));
				hall.setHallCinema(rs.getInt(3));
				return hall;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * 查询所有影厅信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Hall> queryHalls() throws Exception {
		try {
			List<Hall> halls = new ArrayList<Hall>();
			String sql ="select * from hall";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Hall hall=new Hall();
				hall.setHallId(rs.getInt(1));
				hall.setHallName(rs.getString(2));
				halls.add(hall);
			}
			return halls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * 查询某个影院所有影厅信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Hall> queryHallByCinemaCity(String cinemaName, String cityName) throws Exception {
		try {
			List<Hall> halls = new ArrayList<Hall>();
			String sql ="select hall_id,hall_name,hall_cinema from hall,cinema,city where"
					+ " city_id=cinema_city and cinema_id=hall_cinema and cinema_name=? and city_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cinemaName);
			ps.setString(2, cityName);
			rs=ps.executeQuery();
			while(rs.next()) {
				Hall cinema=new Hall();
				cinema.setHallId(rs.getInt(1));
				cinema.setHallName(rs.getString(2));
				cinema.setHallCinema(rs.getInt(3));
				halls.add(cinema);
			}
			return halls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public void deleteHallCinmeaIsNull() throws Exception {
		String sql="delete hall from cinema right join hall on hall.hall_cinema=cinema.cinema_id where cinema_id is null";
		ps=super.getConnection().prepareStatement(sql);
		int i=ps.executeUpdate();
		if(i>0) {
			System.out.println("相关影厅删除成功！");
		}else {
			System.out.println("相关影厅未删除！！！");
		}		
	}
	@Override
	public Hall queryHallById(int hallId) throws Exception {
		try {
			String sql="select hall_id, hall_name,hall_cinema from hall where hall_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, hallId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Hall hall=new Hall();
				hall.setHallId(rs.getInt(1));
				hall.setHallName(rs.getString(2));
				hall.setHallCinema(rs.getInt(3));
				return hall;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * 判断输入影厅编号是否存在
	 */
	@Override
	public int comparisonHallId(int inputHallId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryHalls().size();i++) {
			if(inputHallId==queryHalls().get(i).getHallId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	/**
	 * 判断输入影厅姓名是否存在
	 */
	@Override
	public int comparisonHallName(String inputHallName,String cinemaName,String cityName) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryHallByCinemaCity(cinemaName, cityName).size();i++) {
			if(inputHallName.equals(queryHallByCinemaCity(cinemaName, cityName).get(i).getHallName())) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
