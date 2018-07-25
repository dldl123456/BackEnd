package service;

import java.util.List;

import entity.Hall;

/**
 * 
 * @param 给影厅服务提供接口
 * @author zmx2321
 *
 */

public interface HallService {
	//查询所有影厅
	public boolean querryHall(List<Hall> halllist);
	
	//添加影厅
	public boolean addHall(Hall hall);
	
	//删除影厅
	public boolean deleteHall(int hall_id);
}
