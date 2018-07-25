package dao;

import java.util.List;

import entity.Season;

/**
 * 
 * @param ���������ṩ���ݽӿ�
 * @author zmx2321
 *
 */

public interface SeasonDao {
	//�鿴������Ϣ
	public List<Season> querrySeason();
	
	//��ӳ�����Ϣ
	public int addSeason(Season season);
	
	//ɾ��������Ϣ
	public int deleteSeason(int season_id);
	
	//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
	public Season querySeason(int movie_id, int hall_id) throws Exception;
	
	//���ݳ���id��ѯ��ϸ��Ϣ
	public List<Season> querrySeason(int season_id);
}
