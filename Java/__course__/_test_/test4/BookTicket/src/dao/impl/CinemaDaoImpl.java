package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CinemaDao;
import dbhelp.DbHelp;
import entity.Cinema;

/**
 * 
 * @param 实现影院类数据接口
 * @author zmx2321
 * 
 */

public class CinemaDaoImpl implements CinemaDao {
	private DbHelp db;
	private Connection conn;
	private List<Cinema> list;
	
	//构造方法初始化
	public CinemaDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//查看影院信息
	@Override
	public List<Cinema> querryCinema() {
		conn = db.getConnection();
		String sql = "select * from cinema";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			Cinema cinema;
			//一条一条地记录信息
			while(rs.next()){
				int cinema_id = rs.getInt("cinema_id");
				String cinema_name = rs.getString("cinema_name");
				String cinema_address = rs.getString("cinema_address");
				String cinema_city = rs.getString("cinema_city");
				
				cinema = new Cinema(cinema_id, cinema_name, cinema_address, cinema_city);
						
				list.add(cinema);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	//添加影院信息
	@Override
	public int addCinema(Cinema cinema) {
		conn = db.getConnection();
		String sql = "INSERT INTO `cinema` "
				+ "(`cinema_name`, `cinema_address`, `cinema_city`) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement ps  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cinema.getCinema_name());
			ps.setString(2, cinema.getCinema_address());
			ps.setString(3, cinema.getCinema_city());
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//根据影院id删除影院信息
	@Override
	public int deleteCinema(int cinema_id) {
		conn = db.getConnection();
		String sql = "delete from cinema where cinema_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cinema_id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//test
	public static void main(String[] args) {
		CinemaDao cinemaDao = new CinemaDaoImpl();
		
		//添加影院信息
		/*Cinema cinema = new Cinema("杭州百美汇影城", "下城区延安路385号杭州嘉里中心3号楼4楼", "杭州市");
		System.out.println(cinemaDao.addCinema(cinema));*/
		
		//查看影院信息
		System.out.println("***** 查询 *****");
		List<Cinema> cinemaList = cinemaDao.querryCinema();
		for(Cinema cinema : cinemaList){
			System.out.println(cinema + "\n");
		}
		System.out.println();
		
		//删除影院信息
		/*int cinema_id = Help.getInt("请输入您要删除的影院编号：");
		System.out.println(cinemaDao.deleteCinema(cinema_id));*/
	}
}
