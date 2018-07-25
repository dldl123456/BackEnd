package contro;

import java.util.List;

import dao.CinemaDao;
import dao.impl.CinemaDaoImpl;
import entity.Cinema;
import service.CinemaService;
import service.impl.CinemaServiceImpl;
import util.Help;

/**
 * 
 * @param ӰԺ���Ʋ�
 * @author zmx2321
 * 
 */

public class CinemaContro {
	static CinemaService cinemaService = new CinemaServiceImpl();
	static CinemaDao cinemaDao = new CinemaDaoImpl();
	
	//��ѯ����ӰԺ
	public static void queryCinema() {
		List<Cinema> cinemaList = cinemaDao.querryCinema();
		
		if (cinemaList.isEmpty()) {
			System.out.println("����ӰԺ��\n");
			return;
		}
		
		boolean success = cinemaService.querryCinema(cinemaList);
		
		if (success) {
			for(Cinema cinema : cinemaList){
				System.out.println(cinema + "\n");
			}
			System.out.println();
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		cinemaList.clear();
	}
	
	//���ӰԺ
	public static void addCinema(){
		String cinema_name = Help.getString("������ӰԺ���ƣ�");
		String cinema_address = Help.getString("������ӰԺ��ַ��");
		String cinema_city = Help.getString("������ӰԺ���У�");
		
		Cinema cinema = new Cinema(cinema_name, cinema_address, cinema_city);
		
		boolean success = cinemaService.addCinema(cinema);
		
		if (success) {
			System.out.println("��ӳɹ���\n");
		} else {
			System.out.println("���ʧ�ܣ�\n");
		}
	}
	
	//����ӰԺidɾ��ӰԺ��Ϣ
	public static void deleteCinema(){
		queryCinemaName();
		
		int cinema_id = Help.getInt("��������Ҫɾ����ӰԺ��ţ�");
		
		boolean success = cinemaService.deleteCinema(cinema_id);
		
		if(success){
			System.out.println("ӰԺɾ���ɹ���\n");
			queryCinemaName();
		}else{
			System.out.println("ӰԺɾ��ʧ�ܣ�\n");
		}
	}
	
	//��ѯӰԺ����id
	public static void queryCinemaName(){
		List<Cinema> cinemaList = cinemaDao.querryCinema();
		
		if (cinemaList.isEmpty()) {
			System.out.println("����ӰԺ��\n");
			return;
		}
		
		boolean success = cinemaService.querryCinema(cinemaList);
		
		if (success) {
			for(Cinema cinema : cinemaList){
				System.out.println(cinema.getCinema_id() + "��" + cinema.getCinema_name());
			}
			System.out.println();
		}else {
			System.out.println("��ѯʧ�ܣ�\n");
		}
		
		cinemaList.clear();
	}
	
	//test
	public static void main(String[] args) {
		//���ӰԺ
		//addCinema();
		
		//��ѯ����ӰԺ
		queryCinema();
		
		//ɾ��ӰԺ
		//deleteCinema();
		
		//��ѯӰԺ����id
		//queryCinemaName();
	}
}
