package service.impl;

import java.util.List;

import dao.SeasonDao;
import dao.impl.SeasonDaoImpl;
import entity.Season;
import service.SeasonService;

/**
 * 
 * @param ʵ�ֳ��η���ӿ�
 * @author zmx2321
 * 
 */

public class SeasonServiceImpl implements SeasonService {
	private List<Season> seasonlist = null;
	private Season season = null;  //��ʼ��user
	private int code = 0;  //sqlִ��״̬
	
	private SeasonDao seasonDao;
	
	public SeasonServiceImpl() {
		seasonDao = new SeasonDaoImpl();
	}
	
	//��ѯ���г���
	@Override
	public boolean querySeason() {
		seasonlist = seasonDao.querrySeason();
		
		return seasonlist == null ? false : true;
	}
	
	//��ӳ���
	@Override
	public boolean addSeason(Season season) {
		code = seasonDao.addSeason(season);
		
		return code == 0 ? false : true;
	}
	
	//ɾ������
	@Override
	public boolean deleteSeason(int season_id) {
		code = seasonDao.deleteSeason(season_id);
		
		return code == 0 ? false : true;
	}
	
	//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
	@Override
	public boolean querySeason(int movie_id, int hall_id) throws Exception {
		season = seasonDao.querySeason(movie_id, hall_id);
		
		return season == null ? false : true;
	}
	
	//���ݳ���id��ѯ��ϸ��Ϣ
	@Override
	public boolean querrySeason(int season_id) {
		seasonlist = seasonDao.querrySeason();
		
		return seasonlist == null ? false : true;
	}
	
	
	//test
	public static void main(String[] args) throws Exception {
		SeasonServiceImpl ssi = new SeasonServiceImpl();
		Season season = new Season(1, "2018-4-2 10:00:00", 62, 1);
		
		//��ѯ���г���
		System.out.println(ssi.querySeason());
		
		//��ӳ���
		System.out.println(ssi.addSeason(season));
		
		//ɾ������
		System.out.println(ssi.deleteSeason(3));
		
		//���ݵ�Ӱ��ź�Ӱ����Ų�ѯ���α�ţ����Σ�
		System.out.println(ssi.querySeason(2, 5));
	}
}
