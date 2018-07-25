package service.impl;

import java.util.List;

import dao.SeasonDao;
import dao.impl.SeasonDaoImpl;
import entity.Season;
import service.SeasonService;

/**
 * 
 * @param 实现场次服务接口
 * @author zmx2321
 * 
 */

public class SeasonServiceImpl implements SeasonService {
	private List<Season> seasonlist = null;
	private Season season = null;  //初始化user
	private int code = 0;  //sql执行状态
	
	private SeasonDao seasonDao;
	
	public SeasonServiceImpl() {
		seasonDao = new SeasonDaoImpl();
	}
	
	//查询所有场次
	@Override
	public boolean querySeason() {
		seasonlist = seasonDao.querrySeason();
		
		return seasonlist == null ? false : true;
	}
	
	//添加场次
	@Override
	public boolean addSeason(Season season) {
		code = seasonDao.addSeason(season);
		
		return code == 0 ? false : true;
	}
	
	//删除场次
	@Override
	public boolean deleteSeason(int season_id) {
		code = seasonDao.deleteSeason(season_id);
		
		return code == 0 ? false : true;
	}
	
	//根据电影编号和影厅编号查询场次编号（场次）
	@Override
	public boolean querySeason(int movie_id, int hall_id) throws Exception {
		season = seasonDao.querySeason(movie_id, hall_id);
		
		return season == null ? false : true;
	}
	
	//根据场次id查询详细信息
	@Override
	public boolean querrySeason(int season_id) {
		seasonlist = seasonDao.querrySeason();
		
		return seasonlist == null ? false : true;
	}
	
	
	//test
	public static void main(String[] args) throws Exception {
		SeasonServiceImpl ssi = new SeasonServiceImpl();
		Season season = new Season(1, "2018-4-2 10:00:00", 62, 1);
		
		//查询所有场次
		System.out.println(ssi.querySeason());
		
		//添加场次
		System.out.println(ssi.addSeason(season));
		
		//删除场次
		System.out.println(ssi.deleteSeason(3));
		
		//根据电影编号和影厅编号查询场次编号（场次）
		System.out.println(ssi.querySeason(2, 5));
	}
}
