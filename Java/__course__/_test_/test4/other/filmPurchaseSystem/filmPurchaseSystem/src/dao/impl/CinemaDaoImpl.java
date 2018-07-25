package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CinemaDao;
import dbutil.DbADUClose;
import entity.Cinema;

public class CinemaDaoImpl extends DbADUClose implements CinemaDao {
	/**
	 * 添加影院信息（增）
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addCinema(Cinema cinema) throws Exception {
		String sql="insert into cinema values (default,?,?)";
		Object[] params = {cinema.getCinemaName(),cinema.getCinemaCity()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 根据城市和影院名删除影院（删）
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteCinema(String cityName,String cinemaName) throws Exception {
		String sql="delete cinema from cinema,city where cinema_city=city_id and cinema_name=? and city_name=?;";
		Object[] params = {cityName,cinemaName};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 修改影院信息
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateCinema(Cinema cinema) throws Exception {
		String sql="update cinema set cinema_name=?,cinema_city=? where cinema_id=?";
		Object[] params= {cinema.getCinemaName(),cinema.getCinemaCity(),cinema.getCinemaId()};
		return super.executeUpdate(sql, params);
	}
	/**
	 * 查询单个影院信息
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Cinema queryCinema(String cityName,String cinemaName) throws Exception {
		try {
			String sql="select cinema_id,cinema_name,cinema_city from cinema,city where"
					+ " city_id=cinema_city and city_name=? and cinema_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cityName);
			ps.setString(2, cinemaName);
			rs=ps.executeQuery();
			if(rs.next()) {
				Cinema cinema=new Cinema();
				cinema.setCinemaId(rs.getInt(1));
				cinema.setCinemaName(rs.getString(2));
				cinema.setCinemaCity(rs.getInt(3));
				return cinema;
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
	public Cinema queryCinemaById(int cinemaId) throws Exception {
		try {
			String sql="select * from cinema where cinema_id=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setInt(1, cinemaId);
			rs=ps.executeQuery();
			if(rs.next()) {
				Cinema cinema=new Cinema();
				cinema.setCinemaId(rs.getInt(1));
				cinema.setCinemaName(rs.getString(2));
				cinema.setCinemaCity(rs.getInt(3));
				return cinema;
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
	 * 查询所有影院信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Cinema> queryCinemas() throws Exception {
		try {
			List<Cinema> cinemas = new ArrayList<Cinema>();
			String sql ="select * from cinema";
			ps=super.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cinema cinema=new Cinema();
				cinema.setCinemaId(rs.getInt(1));
				cinema.setCinemaName(rs.getString(2));
				cinemas.add(cinema);
			}
			return cinemas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	/**
	 * 查询某个城市所有影院信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Cinema> queryCinemaByCity(String cityName) throws Exception {
		try {
			List<Cinema> cinemas = new ArrayList<Cinema>();
			String sql ="select cinema_id, cinema_name,cinema_city from cinema,city where"
					+ " city_id=cinema_city and city_name=?";
			ps=super.getConnection().prepareStatement(sql);
			ps.setString(1, cityName);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cinema cinema=new Cinema();
				cinema.setCinemaId(rs.getInt(1));
				cinema.setCinemaName(rs.getString(2));
				cinema.setCinemaCity(rs.getInt(3));
				cinemas.add(cinema);
			}
			return cinemas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}
	@Override
	public int comparisonCinemaId(int inputCinemaId,String cityName) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryCinemaByCity(cityName).size();i++) {
			if(inputCinemaId==queryCinemaByCity(cityName).get(i).getCinemaId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	@Override
	public int comparisonCinemaId(int inputCinemaId) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryCinemas().size();i++) {
			if(inputCinemaId==queryCinemas().get(i).getCinemaId()) {
				Num=i;
				break;
			}
		}
		return Num;
	}
	@Override
	public int comparisonCinemaName(String inputCinemaName, String cityName) throws Exception {
		int Num = -1;//定义一个变量接收传回来的ID
		for(int i=0;i<queryCinemaByCity(cityName).size();i++) {
			if(inputCinemaName.equals(queryCinemaByCity(cityName).get(i).getCinemaName())) {
				Num=i;
				break;
			}
		}
		return Num;
	}
}
