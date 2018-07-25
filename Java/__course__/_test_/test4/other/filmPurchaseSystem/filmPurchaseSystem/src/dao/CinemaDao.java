package dao;

import java.util.List;

import entity.Cinema;

/**
 * 操作影院数据库接口
 * @author Administrator
 *
 */
public interface CinemaDao {
	/**
	 * 添加影院信息（增）
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int addCinema(Cinema cinema) throws Exception;
	/**
	 * 删除影院信息（删）
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int deleteCinema(String cityName,String cinemaName) throws Exception;
	/**
	 * 修改影院信息
	 * @param cinema
	 * @return
	 * @throws Exception
	 */
	public int updateCinema(Cinema cinema) throws Exception;
	/**
	 * 根据城市查询
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public Cinema queryCinema(String cityName,String cinemaName) throws Exception;
	/**
	 * 根据id查询
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public Cinema queryCinemaById(int cinemaId) throws Exception;
	/**
	 * 查询某个城市所有影院信息
	 * @param cinemaId
	 * @return
	 * @throws Exception
	 */
	public List<Cinema> queryCinemaByCity(String cityName) throws Exception;
	/**
	 * 查询所有影院信息
	 * @return
	 * @throws Exception
	 */
	public List<Cinema> queryCinemas() throws Exception;
	/**
	 * 根据id遍历查看影院是否存在
	 * @param inputCinemaId
	 * @return
	 * @throws Exception
	 */
	public int comparisonCinemaId(int inputCinemaId,String cityName) throws Exception;
	public int comparisonCinemaId(int inputCinemaId) throws Exception;
	public int comparisonCinemaName(String inputCinemaName,String cityName) throws Exception;
}
