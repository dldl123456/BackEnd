package contro;

import java.util.List;

import dao.HallDao;
import dao.impl.HallDaoImpl;
import entity.Hall;
import service.HallService;
import service.impl.HallServiceImpl;
import util.Help;

/**
 * 
 * @param Ӱ�����Ʋ�
 * @author zmx2321
 * 
 */

public class HallContro {
	static HallService hallService = new HallServiceImpl();
	static HallDao hallDao = new HallDaoImpl();
	
	//��ѯ����Ӱ��
	public static void queryHall() {
		List<Hall> hallList = hallDao.querryHall();
		
		if (hallList.isEmpty()) {
			System.out.println("����Ӱ����");
		}
		
		boolean success = hallService.querryHall(hallList);
		
		if (success) {
			for(Hall hall : hallList){
				System.out.println("Ӱ����ţ�" + hall.getHall_id() + 
					"\nӰ�����ƣ�" + hall.getHall_name() + 
					"\nӰԺ���ƣ�" + hall.getCinema().getCinema_name() +
					"\n"
				);
			}
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		hallList.clear();
	}
	
	//���Ӱ��
	public static void addHall(){
		String hall_name = Help.getString("������Ӱ�����ƣ�");
		System.out.println();
		
		CinemaContro.queryCinemaName();
		int cinema_id = Help.getInt("������ӰԺ��ţ�");
		
		Hall hall = new Hall(hall_name, cinema_id);
		
		boolean success = hallService.addHall(hall);
		
		if (success) {
			System.out.println("��ӳɹ���\n");
		} else {
			System.out.println("���ʧ�ܣ�\n");
		}
	}
	
	//����ӰԺidɾ��Ӱ����Ϣ
	public static void deleteHall(){
		queryHall();
		
		int hall_id = Help.getInt("��������Ҫɾ����Ӱ����ţ�");
		
		boolean success = hallService.deleteHall(hall_id);
		
		if(success){
			System.out.println("ӰԺɾ���ɹ���\n");
			queryHall();
		}else{
			System.out.println("ӰԺɾ��ʧ�ܣ�\n");
		}
	}
	
	//test
	public static void main(String[] args) {
		//��ѯ����Ӱ��
		//queryHall();
		
		//���Ӱ��
		//addHall();
		
		//ɾ��Ӱ��
		//deleteHall();
	}
}
