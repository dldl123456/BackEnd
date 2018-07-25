package service.impl;

import java.util.List;

import dao.HallDao;
import dao.impl.HallDaoImpl;
import entity.Hall;
import service.HallService;

/**
 * 
 * @param 实现影厅服务接口
 * @author zmx2321
 * 
 */

public class HallServiceImpl implements HallService {
	private static List<Hall> halllist = null;
	private int code = 0;  //sql执行状态
	
	private HallDao hallDao;
	
	public HallServiceImpl() {
		hallDao = new HallDaoImpl();
	}
	
	//查询所有影厅
	@Override
	public boolean querryHall(List<Hall> halllist) {
		halllist = hallDao.querryHall();
		
		return halllist == null ? false : true;
	}
	
	//添加影厅
	@Override
	public boolean addHall(Hall hall) {
		code = hallDao.addHall(hall);
		
		return code == 0 ? false : true;
	}
	
	//删除影厅
	@Override
	public boolean deleteHall(int hall_id) {
		code = hallDao.deleteHall(hall_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		HallServiceImpl hsi = new HallServiceImpl();
		Hall hall = new Hall("1号厅", 1);
		
		//查询所有评论
		System.out.println(hsi.querryHall(halllist));
		
		//添加影院
		System.out.println(hsi.addHall(hall));
		
		//删除影院
		System.out.println(hsi.deleteHall(5));
	}
}
