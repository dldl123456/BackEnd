package service;

import java.util.List;

import entity.Cinema;

/**
 * 
 * @param ��ӰԺ�����ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface CinemaService {
	//��ѯ����ӰԺ
	boolean querryCinema(List<Cinema> cinemalist);
	
	//���ӰԺ
	boolean addCinema(Cinema cinema);
	
	//ɾ����Ӱ
	public boolean deleteCinema(int cinema_id);
}
