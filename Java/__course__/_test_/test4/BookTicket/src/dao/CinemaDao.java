package dao;

import java.util.List;

import entity.Cinema;

/**
 * 
 * @param 给影院类提供数据接口
 * @author zmx2321
 *
 */

public interface CinemaDao {
	//查看影院信息
	public List<Cinema> querryCinema();
	
	//添加影院信息
	public int addCinema(Cinema cinema);
	
	//根据影院id删除影院信息
	public int deleteCinema(int cinema_id);
}
