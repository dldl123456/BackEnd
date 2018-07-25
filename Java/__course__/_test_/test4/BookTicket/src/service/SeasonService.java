package service;

import entity.Season;

/**
 * 
 * @param 给场次服务提供接口
 * @author zmx2321
 *
 */

public interface SeasonService {
	//查询所有场次
	public boolean querySeason();
	
	//添加场次
	public boolean addSeason(Season season);
	
	//删除场次
	public boolean deleteSeason(int season_id);
	
	//根据电影编号和影厅编号查询场次编号（场次）
	public boolean querySeason(int movie_id, int hall_id) throws Exception;

	//根据场次id查询详细信息
	public boolean querrySeason(int season_id);
}
