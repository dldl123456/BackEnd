package service.impl;

import java.util.List;

import dao.CinemaDao;
import dao.impl.CinemaDaoImpl;
import entity.Cinema;
import service.CinemaService;

/**
 * 
 * @param ʵ��ӰԺ����ӿ�
 * @author zmx2321
 * 
 */

public class CinemaServiceImpl implements CinemaService {
	private static List<Cinema> cinemalist = null;
	private int code = 0;  //sqlִ��״̬
	
	private CinemaDao cinemaDao;
	
	public CinemaServiceImpl() {
		cinemaDao = new CinemaDaoImpl();
	}
	
	//��ѯ����ӰԺ
	@Override
	public boolean querryCinema(List<Cinema> cinemalist) {
		cinemalist = cinemaDao.querryCinema();
		
		return cinemalist == null ? false : true;
	}
	
	//���ӰԺ
	@Override
	public boolean addCinema(Cinema cinema) {
		code = cinemaDao.addCinema(cinema);
		
		return code == 0 ? false : true;
	}
	
	//ɾ����Ӱ
	@Override
	public boolean deleteCinema(int cinema_id) {
		code = cinemaDao.deleteCinema(cinema_id);
		
		return code == 0 ? false : true;
	}
	
	//test
	public static void main(String[] args) {
		CinemaServiceImpl csi = new CinemaServiceImpl();
		Cinema cinema = new Cinema("���ݰ�����Ӱ��", "�³����Ӱ�·385�ź��ݼ�������3��¥4¥", "������");
		
		//��ѯ��������
		System.out.println(csi.querryCinema(cinemalist));
		
		//���ӰԺ
		System.out.println(csi.addCinema(cinema));
		
		//ɾ��ӰԺ
		System.out.println(csi.deleteCinema(1));
	}
}
