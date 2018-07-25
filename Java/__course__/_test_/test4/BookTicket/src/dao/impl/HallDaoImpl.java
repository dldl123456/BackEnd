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
 * @param ʵ��Ӱ�������ݽӿ�
 * @author zmx2321
 * 
 */

public class HallDaoImpl implements HallDao {
	private DbHelp db;
	private Connection conn;
	private List<Hall> list;
	
	//���췽����ʼ��
	public HallDaoImpl() {
		db = new DbHelp();
		list = new ArrayList<>();
	}

	//�鿴Ӱ����Ϣ
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

			//һ��һ���ؼ�¼��Ϣ
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

	//���Ӱ����Ϣ
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
			
			return ps.executeUpdate();//ִ�в��������ݿ�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll(conn, ps, null);
		}
		
		return 0;
	}

	//ɾ��Ӱ����Ϣ
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
		
		//���Ӱ����Ϣ
		/*Hall hall = new Hall("1����", 1);
		System.out.println(hallDao.addHall(hall));
		System.out.println();*/
		
		//�鿴Ӱ����Ϣ
		System.out.println("***** ��ѯ *****");
		List<Hall> hallList = hallDao.querryHall();
		for(Hall hall : hallList){
			System.out.println("Ӱ����ţ�" + hall.getHall_id() + 
				"\nӰ�����ƣ�" + hall.getHall_name() + 
				"\nӰԺ���ƣ�" + hall.getCinema().getCinema_name() +
				"\n"
			);
		}
		System.out.println();
		
		//ɾ��Ӱ����Ϣ
		//System.out.println(hallDao.deleteHall(1));
	}
}
