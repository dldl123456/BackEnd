package dao;

import java.util.List;

import entity.Hall;

/**
 * 
 * @param ��Ӱ�����ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface HallDao {
	//�鿴Ӱ����Ϣ
	public List<Hall> querryHall();
	
	//���Ӱ����Ϣ
	public int addHall(Hall hall);
	
	//����Ӱ��idɾ��Ӱ����Ϣ
	public int deleteHall(int hall_id);
}
