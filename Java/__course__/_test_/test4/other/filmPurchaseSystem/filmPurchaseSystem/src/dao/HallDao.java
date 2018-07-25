package dao;

import java.util.List;

import entity.Hall;
/**
 * 操作影厅数据库接口
 * @author Administrator
 *
 */
public interface HallDao {
	/**
	 * 添加影厅（增）
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int addHall(Hall hall) throws Exception;
	/**
	 * 删除影厅（删）
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int deleteHall(String cityName,String cinemaName,String hallName) throws Exception;
	/**
	 * 删除电影院不存在的影厅
	 */
	public void deleteHallCinmeaIsNull() throws Exception;
	
	/**
	 * 修改影厅信息
	 * @param hall
	 * @return
	 * @throws Exception
	 */
	public int updateHallName(String hallName,int hallId) throws Exception;
	/**
	 * 根据城市和影院查询影厅信息
	 * @param hallId
	 * @return
	 * @throws Exception
	 */
	public Hall queryHall(String cityName,String cinemaName,String hallName) throws Exception;
	/**
	 * 根据id查询影厅
	 */
	public Hall queryHallById(int hallId) throws Exception;
	/**
	 * 查询所有影厅信息
	 * @return
	 * @throws Exception
	 */
	public List<Hall> queryHalls() throws Exception;
	/**
	 * 查询某个城市所有影院信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Hall> queryHallByCinemaCity(String cinemaName,String cityName) throws Exception;
	
	public int comparisonHallId(int inputHallId) throws Exception;
	
	public int comparisonHallName(String inputHallName,String cinemaName,String cityName) throws Exception;
}
