package service;

import entity.Season;

/**
 * 
 * @param �����η����ṩ�ӿ�
 * @author zmx2321
 *
 */

public interface SeasonService {
	//��ѯ���г���
	public boolean querySeason();
	
	//��ӳ���
	public boolean addSeason(Season season);
	
	//ɾ������
	public boolean deleteSeason(int season_id);
	
	//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
	public boolean querySeason(int movie_id, int hall_id) throws Exception;

	//���ݳ���id��ѯ��ϸ��Ϣ
	public boolean querrySeason(int season_id);
}
