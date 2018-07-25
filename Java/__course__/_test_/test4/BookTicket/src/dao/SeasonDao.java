package dao;

import java.util.List;

import entity.Season;

/**
 * 
 * @param 给场次类提供数据接口
 * @author zmx2321
 *
 */

public interface SeasonDao {
	//查看场次信息
	public List<Season> querrySeason();
	
	//添加场次信息
	public int addSeason(Season season);
	
	//删除场次信息
	public int deleteSeason(int season_id);
	
	//根据电影编号和影厅编号查询场次编号（场次）
	public Season querySeason(int movie_id, int hall_id) throws Exception;
	
	//根据场次id查询详细信息
	public List<Season> querrySeason(int season_id);
}
