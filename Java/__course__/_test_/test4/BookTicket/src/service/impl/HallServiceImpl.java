package service.impl;

import java.util.List;

import dao.HallDao;
import dao.impl.HallDaoImpl;
import entity.Hall;
import service.HallService;

/**
 * 
 * @param ʵ��Ӱ������ӿ�
 * @author zmx2321
 * 
 */

public class HallServiceImpl implements HallService {
	private static List<Hall> halllist = null;
	private int code = 0;  //sqlִ��״̬
	
	private HallDao hallDao;
	
	public HallServiceImpl() {
		hallDao = new HallDaoImpl();
	}
	
	//��ѯ����Ӱ��
	@Override
	public boolean querryHall(List<Hall> halllist) {
		halllist = hallDao.querryHall();
		
		return halllist == null ? false : true;
	}
	
	//���Ӱ��
	@Override
	public boolean addHall(Hall hall) {
		code = hallDao.addHall(hall);
		
		return code == 0 ? false : true;
	}
	
	//ɾ��Ӱ��
	@Override
	public boolean deleteHall(int hall_id) {
		code = hallDao.deleteHall(hall_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		HallServiceImpl hsi = new HallServiceImpl();
		Hall hall = new Hall("1����", 1);
		
		//��ѯ��������
		System.out.println(hsi.querryHall(halllist));
		
		//���ӰԺ
		System.out.println(hsi.addHall(hall));
		
		//ɾ��ӰԺ
		System.out.println(hsi.deleteHall(5));
	}
}
