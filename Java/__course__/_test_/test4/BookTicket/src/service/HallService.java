package service;

import java.util.List;

import entity.Hall;

/**
 * 
 * @param ��Ӱ�������ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface HallService {
	//��ѯ����Ӱ��
	public boolean querryHall(List<Hall> halllist);
	
	//���Ӱ��
	public boolean addHall(Hall hall);
	
	//ɾ��Ӱ��
	public boolean deleteHall(int hall_id);
}
