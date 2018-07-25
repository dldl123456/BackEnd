package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeasonDao;
import dbhelp.DbHelp;
import entity.Cinema;
import entity.Hall;
import entity.Movie;
import entity.Season;

/**
 * 
 * @param 实现场次类数据接口
 * @author zmx2321
 * 
 */

public class SeasonDaoImpl implements SeasonDao {
	private DbHelp db;
	private Connection conn;
	private List<Season> list;
	
	//构造方法初始化
	public SeasonDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//查看场次信息
	@Override
	public List<Season> querrySeason() {
		conn = db.getConnection();
		String sql = "SELECT s.season_id, c.cinema_name, h.hall_name, m.movie_name, m.movie_length, "
				+ "s.season_price, s.season_time, c.cinema_address "
				+ "FROM season s, movie m, hall h, cinema c WHERE s.movie_id = m.movie_id "
				+ "AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//一条一条地记录信息
			while(rs.next()){
				Season season = new Season();
				
				season.setCinema(new Cinema());
				season.setMovie(new Movie());
				season.setHall(new Hall());
				
				season.setSeason_id(rs.getInt("season_id"));
				season.getCinema().setCinema_name(rs.getString("cinema_name"));
				season.getHall().setHall_name(rs.getString("hall_name"));
				season.getMovie().setMovie_name(rs.getString("movie_name"));
				season.getMovie().setMovie_length(rs.getString("movie_length"));
				season.setSeason_price(rs.getFloat("season_price"));
				season.setSeason_time(rs.getString("season_time"));
				season.getCinema().setCinema_address(rs.getString("cinema_address"));
						
				list.add(season);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	//添加场次信息
	@Override
	public int addSeason(Season season) {
		conn = db.getConnection();
		String sql = "INSERT INTO `season` "
				+ "(`movie_id`, `season_time`, `season_price`, `hall_id`) "
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, season.getMovie_id());
			ps.setString(2, season.getSeason_time());
			ps.setFloat(3, season.getSeason_price());
			ps.setInt(4, season.getHall_id());
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			System.out.println("添加失败！\n");
		} finally {
			db.closeAll(conn, ps);
		}
		
		return 0;
	}

	//删除场次信息
	@Override
	public int deleteSeason(int season_id) {
		conn = db.getConnection();
		String sql = "delete from season where season_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, season_id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}
	
	//根据电影编号和影厅编号查询场次编号（场次）
	@Override
	public Season querySeason(int movieid, int hallid){
		Season season = null;
		
		conn = db.getConnection();
		String sql = "SELECT * FROM season WHERE movie_id = ? AND hall_id = ?";
		
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, movieid);
			ps.setInt(2, hallid);
			
			rs = ps.executeQuery();
			
			//一条一条地记录信息
			while(rs.next()){
				int season_id = rs.getInt("season_id");
				int movie_id = rs.getInt("movie_id");
				String season_time = rs.getString("season_time");
				float season_price = rs.getFloat("season_price");
				int hall_id = rs.getInt("hall_id");
				
				season = new Season(season_id, movie_id, season_time, season_price, hall_id);
				
				return season;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//根据场次id查询详细信息
	@Override
	public List<Season> querrySeason(int season_id) {
		Season season = null;
		
		conn = db.getConnection();
		String sql = "SELECT s.season_id, c.cinema_name, h.hall_name, m.movie_name, m.movie_length, "
				+ "s.season_price, s.season_time, c.cinema_address "
				+ "FROM season s, movie m, hall h, cinema c WHERE s.movie_id = m.movie_id "
				+ "AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id AND season_id = ?";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, season_id);
			
			rs = ps.executeQuery();
			
			//一条一条地记录信息
			while(rs.next()){
				season = new Season();
				
				season.setCinema(new Cinema());
				season.setMovie(new Movie());
				season.setHall(new Hall());
				
				season.setSeason_id(rs.getInt("season_id"));
				season.getCinema().setCinema_name(rs.getString("cinema_name"));
				season.getHall().setHall_name(rs.getString("hall_name"));
				season.getMovie().setMovie_name(rs.getString("movie_name"));
				season.getMovie().setMovie_length(rs.getString("movie_length"));
				season.setSeason_price(rs.getFloat("season_price"));
				season.setSeason_time(rs.getString("season_time"));
				season.getCinema().setCinema_address(rs.getString("cinema_address"));
						
				list.add(season);
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
		SeasonDaoImpl seasonDao = new SeasonDaoImpl();
		
		//添加场次信息
		Season season = new Season(1, "2018-4-2 10:00:00", 62, 1);
		System.out.println(seasonDao.addSeason(season));
		System.out.println();
		
		//查看场次信息
		/*System.out.println("***** 查询 *****");
		List<Season> seasonList = seasonDao.querrySeason();
		for(Season season : seasonList){
			System.out.println("场次编号：" + season.getSeason_id() + 
				"\n影院名称：" + season.getCinema().getCinema_name() +
				"\n影厅名称：" + season.getHall().getHall_name() +
				"\n电影名称：" + season.getMovie().getMovie_name() +
				"\n电影时长：" + season.getMovie().getMovie_length() +
				"\n支付价格：" + season.getSeason_price() + 
				"\n放映时间：" + season.getSeason_time() + 
				"\n放映地址：" + season.getCinema().getCinema_address() + 
				"\n"
			);
		}
		System.out.println();*/
		
		//删除场次信息
		//System.out.println(seasonDao.deleteSeason(1));
		
		//根据电影编号和影厅编号查询场次编号（场次）
		/*Season season = seasonDao.querySeason(2, 5);
		System.out.println(season);*/
		
		//查看场次信息
		/*System.out.println("***** 查询 *****");
		List<Season> seasonList = seasonDao.querrySeason(3);
		for(Season season : seasonList){
			System.out.println("场次编号：" + season.getSeason_id() + 
				"\n影院名称：" + season.getCinema().getCinema_name() +
				"\n影厅名称：" + season.getHall().getHall_name() +
				"\n电影名称：" + season.getMovie().getMovie_name() +
				"\n电影时长：" + season.getMovie().getMovie_length() +
				"\n支付价格：" + season.getSeason_price() + 
				"\n放映时间：" + season.getSeason_time() + 
				"\n放映地址：" + season.getCinema().getCinema_address() + 
				"\n"
			);
		}
		System.out.println();*/
	}
}
