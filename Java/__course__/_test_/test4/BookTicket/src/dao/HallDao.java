package dao;

import java.util.List;

import entity.Hall;

/**
 * 
 * @param 给影厅类提供数据接口
 * @author zmx2321
 *
 */

public interface HallDao {
	//查看影厅信息
	public List<Hall> querryHall();
	
	//添加影厅信息
	public int addHall(Hall hall);
	
	//根据影厅id删除影厅信息
	public int deleteHall(int hall_id);
}
