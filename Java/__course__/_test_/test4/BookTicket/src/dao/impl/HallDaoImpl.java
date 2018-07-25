package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.HallDao;
import dbhelp.DbHelp;
import entity.Cinema;
import entity.Hall;

/**
 * 
 * @param 实现影厅类数据接口
 * @author zmx2321
 * 
 */

public class HallDaoImpl implements HallDao {
	private DbHelp db;
	private Connection conn;
	private List<Hall> list;
	
	//构造方法初始化
	public HallDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//查看影厅信息
	@Override
	public List<Hall> querryHall() {
		conn = db.getConnection();
		String sql = "SELECT h.hall_id, h.hall_name, c.cinema_name "
				+ "FROM hall h, cinema c "
				+ "WHERE h.cinema_id = c.cinema_id";
		
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			//一条一条地记录信息
			while(rs.next()){
				Hall hall = new Hall();
				
				hall.setCinema(new Cinema());
				
				hall.setHall_id(rs.getInt("hall_id"));
				hall.setHall_name(rs.getString("hall_name"));
				hall.getCinema().setCinema_name(rs.getString("cinema_name"));
						
				list.add(hall);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, rs);
		}
		
		return list;
	}

	//添加影厅信息
	@Override
	public int addHall(Hall hall) {
		conn = db.getConnection();
		String sql = "INSERT INTO `hall` "
				+ "(`hall_name`, `cinema_id`) "
				+ "VALUES (?, ?)";
		
		PreparedStatement ps  = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hall.getHall_name());
			ps.setInt(2, hall.getCinema_id());
			
			return ps.executeUpdate();//执行并更新数据库内容
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//删除影厅信息
	@Override
	public int deleteHall(int hall_id) {
		conn = db.getConnection();
		String sql = "delete from hall where hall_id = ?";
		PreparedStatement ps  = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, hall_id);
			
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
		HallDaoImpl hallDao = new HallDaoImpl();
		
		//添加影厅信息
		/*Hall hall = new Hall("1号厅", 1);
		System.out.println(hallDao.addHall(hall));
		System.out.println();*/
		
		//查看影厅信息
		System.out.println("***** 查询 *****");
		List<Hall> hallList = hallDao.querryHall();
		for(Hall hall : hallList){
			System.out.println("影厅编号：" + hall.getHall_id() + 
				"\n影厅名称：" + hall.getHall_name() + 
				"\n影院名称：" + hall.getCinema().getCinema_name() +
				"\n"
			);
		}
		System.out.println();
		
		//删除影厅信息
		//System.out.println(hallDao.deleteHall(1));
	}
}
