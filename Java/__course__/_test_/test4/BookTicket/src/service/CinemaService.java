package service;

import java.util.List;

import entity.Cinema;

/**
 * 
 * @param 给影院服务提供接口
 * @author zmx2321
 *
 */

public interface CinemaService {
	//查询所有影院
	boolean querryCinema(List<Cinema> cinemalist);
	
	//添加影院
	boolean addCinema(Cinema cinema);
	
	//删除电影
	public boolean deleteCinema(int cinema_id);
}
