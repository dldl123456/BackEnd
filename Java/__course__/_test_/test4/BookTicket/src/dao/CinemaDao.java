package dao;

import java.util.List;

import entity.Cinema;

/**
 * 
 * @param ��ӰԺ���ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface CinemaDao {
	//�鿴ӰԺ��Ϣ
	public List<Cinema> querryCinema();
	
	//���ӰԺ��Ϣ
	public int addCinema(Cinema cinema);
	
	//����ӰԺidɾ��ӰԺ��Ϣ
	public int deleteCinema(int cinema_id);
}
