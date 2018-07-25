package com.iotek.dao;

import java.util.List;
import com.iotek.entity.ShowHall;
import com.iotek.entity.Theater;

public interface IShowHallDao {
	/**
	 * 获取影厅对象
	 * @param id
	 * @return
	 */
	public ShowHall selectShowHall(int id);
	/**
	 * 添加影厅（除id外其他要都是完整的）
	 * @param hall
	 * @return
	 */
	public boolean addShowHall(ShowHall hall);
	/**
	 * 删除影厅（未上映过电影的影厅）
	 * @param hall
	 * @return
	 */
	public boolean deleteShowHall(ShowHall hall);
	/**
	 * 查找某电影院的所有影厅
	 * @param t
	 * @return
	 */
	public List<ShowHall> selectAllShowHalls(Theater t);
	/**
	 * 更新影厅信息
	 * @param hall
	 * @return
	 */
	public boolean updateShowHall(ShowHall hall);
}
